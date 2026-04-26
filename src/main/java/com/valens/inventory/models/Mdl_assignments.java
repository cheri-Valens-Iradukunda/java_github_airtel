package com.valens.inventory.models;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Mdl_assignments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueDate;
    private String returnDate;
    private String status; // Active, Returned
    private String remarks;

    @ManyToOne
    private Mdl_device device;

    @ManyToOne
    private Mdl_employees employee;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIssueDate() { return issueDate; }
    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }

    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Mdl_device getDevice() { return device; }
    public void setDevice(Mdl_device device) { this.device = device; }

    public Mdl_employees getEmployee() { return employee; }
    public void setEmployee(Mdl_employees employee) { this.employee = employee; }
}

