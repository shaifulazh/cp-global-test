package com.example.demo.models;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// • Id
// • Employee id
// • Employee name
// • Department
// • Dob
// • Email
// • Phone number
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeID;
    private String employeeName;
    private String department;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;

    public Employee() {
        super();
    }

    public Employee(Long id, String employeeID, String employeeName, String department , Date dateOfBirth, String email, String phoneNumber){
        super();
        this.id = id;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(String employerID){
        this.employeeID = employerID;
    }


    public String getEmployeeName() {
      return this.employeeName;
    }
    public void setEmployeeName(String value) {
      this.employeeName = value;
    }

    public String getDepartment() {
      return this.department;
    }
    public void setDepartment(String value) {
      this.department = value;
    }

    public Date getDateOfBirth() {
      return this.dateOfBirth;
    }
    public void setDateOfBirth(Date value) {
      this.dateOfBirth = value;
    }

    public String getEmail() {
      return this.email;
    }
    public void setEmail(String value) {
      this.email = value;
    }

    public String getPhoneNumber() {
      return this.phoneNumber;
    }
    public void setPhoneNumber(String value) {
      this.phoneNumber = value;
    }
}
