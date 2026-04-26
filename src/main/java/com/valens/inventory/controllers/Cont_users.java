package com.valens.inventory.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valens.inventory.models.Mdl_users;
import com.valens.inventory.repositories.Repo_users;

import net.bytebuddy.build.Plugin.Engine.Summary;

@Controller
@RequestMapping("/users")
public class Cont_users {
	
	@Autowired
	Repo_users repo_users;
	
	//inserting new user form
	@GetMapping("/")
	public String createUserForm(Model model) {
		model.addAttribute("obj",new Mdl_users());
		
		return "users/signUp";
	}
	
	//updating form
	@GetMapping("/update/{id}")
	public String createUserForm(Model model,@PathVariable Long id) {
		model.addAttribute("obj",repo_users.findById(id).orElse(null));
		return "users/signUp";
	}
	@GetMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		repo_users.deleteById(id);
		return "redirect:all";
	}
	
	//insert and update data
	@PostMapping("/")
	public String saveUser(Mdl_users user) {
		repo_users.save(user);
		System.out.println("saved");
		return "redirect:/users/auth";
	}
	
	@GetMapping("/all")
	public String getAllusers(Model model) {
		model.addAttribute("users",repo_users.findAll());
		return "users/auth";
	}
	
	
	
	@GetMapping("/auth")
	public String loginForm() {
		return "users/login";
	}
	@PostMapping("/login")
	public String login(Mdl_users user, HttpSession session) {
		try {
			
		
		Mdl_users selectedUser = repo_users.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(selectedUser == null) {
			System.out.println("not found");
			return "redirect:auth";
		}else{
			System.out.println("found");
			session.setAttribute("id", selectedUser.getId());
			session.setAttribute("role", selectedUser.getRole());
			
			return "redirect:/";
		}
		} catch (Exception e) {
			return "redirect:/users/auth";
		}
		
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {

	    // destroy session
	    session.invalidate();

	    // redirect to login page
	    return "redirect:/users/auth";
	}
}

