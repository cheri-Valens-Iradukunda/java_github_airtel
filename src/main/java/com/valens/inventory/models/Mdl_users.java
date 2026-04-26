package com.valens.inventory.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Mdl_users {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String username;
	    private String password;
	    private String role; // Admin, Staff, etc.
	    
	    @OneToMany(mappedBy = "userUpdates")
	    List<Mdl_auditLog> userUpdates;
	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getUsername() { return username; }
	    public void setUsername(String username) { this.username = username; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

	    public String getRole() { return role; }
	    public void setRole(String role) { this.role = role; }
	    
	    public List<Mdl_auditLog> getUserUpdates() { return userUpdates; }
	    public void setUserUpdates(List<Mdl_auditLog> userUpdate) { this.userUpdates = userUpdate; }

}
