package com.valens.inventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auditLog")
public class Mdl_auditLog {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String action; // Issued, Returned, Updated, Registered, Decommissioned
	    private String timestamp;
	    private String performedBy;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    Mdl_users userUpdates;
	    
	    @ManyToOne
	    private Mdl_device device;

	    @ManyToOne
	    private Mdl_employees employee;
	    
	    

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getAction() { return action; }
	    public void setAction(String action) { this.action = action; }

	    public String getTimestamp() { return timestamp; }
	    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

	    public String getPerformedBy() { return performedBy; }
	    public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }

	    public Mdl_device getDevice() { return device; }
	    public void setDevice(Mdl_device device) { this.device = device; }

	    public Mdl_employees getEmployee() { return employee; }
	    public void setEmployee(Mdl_employees employee) { this.employee = employee; }

}
