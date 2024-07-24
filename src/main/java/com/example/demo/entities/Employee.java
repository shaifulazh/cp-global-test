package com.example.demo.entities;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;

    public Employee() {}

    public Employee(String employeeID, String employeeName, String department , LocalDate dateOfBirth, String email, String phoneNumber){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
    public Long getID() {
      return this.id;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(String value){
        this.employeeID = value;
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

    public LocalDate getDateOfBirth() {
      return this.dateOfBirth;
    }
    public void setDateOfBirth(LocalDate value) {
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
