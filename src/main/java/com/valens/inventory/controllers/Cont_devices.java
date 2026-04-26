package com.valens.inventory.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valens.inventory.models.Mdl_device;
import com.valens.inventory.repositories.Repo_device;

@Controller
@RequestMapping("/devices")
public class Cont_devices {
	
	@Autowired
	Repo_device deviceRepository;
	
	@GetMapping("/")
	public String listDevices(Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
	    model.addAttribute("devices", deviceRepository.findAll());
	    return "devices/list";
	}

	@GetMapping("/add")
	public String newDevice(Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
	    model.addAttribute("device", new Mdl_device());
	    return "devices/addNew";
	}

	@PostMapping("/")
	public String saveDevice(@ModelAttribute Mdl_device device) {
	    deviceRepository.save(device);
	    return "redirect:/devices/";
	}

	@GetMapping("/edit/{id}")
	public String editDevice(@PathVariable Long id, Model model,HttpSession session) {
		if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
		
	    model.addAttribute("device", deviceRepository.findById(id).orElse(null));
	    return "devices/addNew";
	}

	@GetMapping("/delete/{id}")
	public String deleteDevice(@PathVariable Long id) {
	    deviceRepository.deleteById(id);
	    return "redirect:/devices/";
	}
	
}
