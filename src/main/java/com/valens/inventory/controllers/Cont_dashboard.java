package com.valens.inventory.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.valens.inventory.repositories.Repo_assignemts;
import com.valens.inventory.repositories.Repo_auditLog;
import com.valens.inventory.repositories.Repo_department;
import com.valens.inventory.repositories.Repo_device;
import com.valens.inventory.repositories.Repo_employees;

@Controller
public class Cont_dashboard {
	
	@Autowired
	Repo_device repo_devices;
	
	@Autowired
	Repo_assignemts repo_assignments;
	
	@Autowired
	Repo_department repo_departments;
	
	@Autowired
	Repo_employees repo_employees;
	
	@Autowired
	Repo_auditLog repo_auditLog;
	
	@GetMapping("/")
	public String showDashboard(Model model,HttpSession session) {
		 if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
		model.addAttribute("availableDeviceCount",repo_devices.countDeviceByStatus("available"));
		model.addAttribute("damagedDeviceCount",repo_devices.countDeviceByStatus("damaged"));
		model.addAttribute("issuedDeviceCount", repo_devices.countDeviceByStatus("issued"));
		model.addAttribute("underRepairCount", repo_devices.countDeviceByStatus("under repair"));
		model.addAttribute("allDevicesCount",repo_devices.count());
		model.addAttribute("employeesCount",repo_employees.count());
		
		return "Dashboard/Dashboard";
	}
	

}
