package com.valens.inventory.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valens.inventory.models.Mdl_employees;
import com.valens.inventory.repositories.Repo_department;
import com.valens.inventory.repositories.Repo_employees;

@Controller
@RequestMapping("/employees")
public class Cont_employees {

	@Autowired
	Repo_department repo_department;
	
	@Autowired
	Repo_employees repo_employees;
	
	@GetMapping("/")
	public String getAllEmployees(Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
		model.addAttribute("employees", repo_employees.findAll());
		
		return "employees/list";
	}
	
	@GetMapping("/add")
	public String employeesForm(Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
		model.addAttribute("obj", new Mdl_employees());
		model.addAttribute("departments", repo_department.findAll());
		
		return "/employees/addNew";
	}
	
	@PostMapping
	public String addEmployee(Mdl_employees employee) {
		repo_employees.save(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		repo_employees.deleteById(id);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/edit/{id}")
	public String updateEmployee(@PathVariable Long id,Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
		model.addAttribute("obj",repo_employees.findById(id).orElse(null));

		model.addAttribute("departments", repo_department.findAll());
		
		return "employees/addNew";
	}
	
}
