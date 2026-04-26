package com.valens.inventory.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employees")
public class Mdl_employees {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String email;
	    private String phone;

	    @OneToMany(mappedBy = "employee")
	    private List<Mdl_assignments> assignments;
	    
	    @ManyToOne
	    private Mdl_department department;

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public Mdl_department getDepartment() { return department; }
	    public void setDepartment(Mdl_department department) { this.department = department; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }

	    public List<Mdl_assignments> getAssignments() { return assignments; }
	    public void setAssignments(List<Mdl_assignments> assignments) { this.assignments = assignments; }

}
