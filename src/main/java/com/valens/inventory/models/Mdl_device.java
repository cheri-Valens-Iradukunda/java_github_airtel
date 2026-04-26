package com.valens.inventory.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "devices")
public class Mdl_device {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String serialNumber;
	    private String type; // Laptop, Desktop, Mobile
	    private String brand;
	    private String model;
	    private String status; // Available, Issued, under repair

	    @OneToMany(mappedBy = "device")
	    private List<Mdl_assignments> assignments;

	    @OneToMany(mappedBy = "device")
	    private List<Mdl_auditLog> auditLogs;

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getSerialNumber() { return serialNumber; }
	    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

	    public String getType() { return type; }
	    public void setType(String type) { this.type = type; }

	    public String getBrand() { return brand; }
	    public void setBrand(String brand) { this.brand = brand; }

	    public String getModel() { return model; }
	    public void setModel(String model) { this.model = model; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public List<Mdl_assignments> getAssignments() { return assignments; }
	    public void setAssignments(List<Mdl_assignments> assignments) { this.assignments = assignments; }

	    public List<Mdl_auditLog> getAuditLogs() { return auditLogs; }
	    public void setAuditLogs(List<Mdl_auditLog> auditLogs) { this.auditLogs = auditLogs; }


}
