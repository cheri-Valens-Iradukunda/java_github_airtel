package com.valens.inventory.controllers;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valens.inventory.models.Mdl_assignments;
import com.valens.inventory.models.Mdl_device;
import com.valens.inventory.repositories.Repo_assignemts;
import com.valens.inventory.repositories.Repo_device;
import com.valens.inventory.repositories.Repo_employees;

@Controller
@RequestMapping("assign")
public class Cont_assignment {

	@Autowired
	Repo_assignemts repo_assignments;
	
	@Autowired
	Repo_employees repo_employees;

	@Autowired
	Repo_device repo_devices;
	
	@GetMapping("/")
	public String list(Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
	    model.addAttribute("assignments", repo_assignments.findAll());
	    return "assign/list";
	}

	@GetMapping("/add")
	public String newAssignment(Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
	    model.addAttribute("assignment", new Mdl_assignments());
	    model.addAttribute("devices", repo_devices.deviceByStatus("available"));
	    model.addAttribute("employees", repo_employees.findAll());
	    return "assign/addNew";
	}
	
	@PostMapping("/")
	public String saveAssignemt(Mdl_assignments assignments) {
		repo_assignments.save(assignments);
		long id = assignments.getDevice().getId();
		Mdl_device device = repo_devices.findById(id).orElse(null);
		device.setStatus("issued");
		repo_devices.save(device);
		
		return "redirect:/assign/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAssignemt(@PathVariable Long id) {
		Mdl_assignments assignment = repo_assignments.findById(id).orElse(null);
		
		Mdl_device device = assignment.getDevice();
		device.setStatus("available");
		repo_assignments.deleteById(id);
		repo_devices.save(device);
		
		return "redirect:/assign/";
	}
	@GetMapping("/return/{id}")
	public String returnDevice(@PathVariable Long id) {
		Mdl_assignments assignment = repo_assignments.findById(id).orElse(null);
		assignment.setStatus("returned");
		repo_assignments.save(assignment);
		Mdl_device device = assignment.getDevice();
		device.setStatus("available");
		repo_devices.save(device);
		
		return "redirect:/assign/";
	}
	
	
	
}
