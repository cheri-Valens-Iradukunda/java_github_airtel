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

import com.valens.inventory.models.Mdl_department;
import com.valens.inventory.repositories.Repo_department;

@Controller
@RequestMapping("/department")
public class Cont_department {
	@Autowired
    private Repo_department repo_department;

    // ✅ Display all departments
    @GetMapping("/")
    public String listDepartments(Model model,HttpSession session) {
    	if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
        model.addAttribute("departments", repo_department.findAll());
        return "department/allDipartments"; // Thymeleaf template
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model,HttpSession session) {
    	if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
        model.addAttribute("department", new Mdl_department());
        return "department/addNew"; // Thymeleaf template
    }
    
    @PostMapping("/")
    public String saveDepartment(@ModelAttribute Mdl_department department) {
        repo_department.save(department);
        return "redirect:/department/";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model,HttpSession session) {
    	if (session.getAttribute("id") == null) {
	        return "redirect:/users/auth";
	    }
        Mdl_department dept = repo_department.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid department Id:" + id));
        model.addAttribute("department", dept);
        return "department/addNew"; // reuse same form
    }
    
    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        repo_department.deleteById(id);
        return "redirect:/department";
    }
}
