package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;

    //To get all employee list
    @GetMapping("/employee")
    public ResponseEntity<?> getAllEmployee() {

        try {
            List<Employee> employees = new ArrayList<>();
            employeeRepository.findAll().forEach(employees::add);
            if (employees.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //to get one employer by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long id){
        Optional<Employee> employeeData = employeeRepository.findById(id);

        if (employeeData.isPresent()){
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        }else {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }

    //create employee using json{
    // 	"employeeID" : "00001",
    // 	"employeeName" : "myname",
    // 	"department" : "IT",
    // 	"dateOfBirth" : "04-09-2023",
    // 	"email" : "test@test.com",
    // 	"phoneNumber" : "0123456789"
    // } 

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){

        // todo check if emplyeeid have same with requestbody will throw error exist

        try {
            Employee newEmployee = employeeRepository.save(new Employee(
                employee.getEmployeeID(), 
                employee.getEmployeeName(),
                employee.getDepartment(), 
                employee.getDateOfBirth(),
                employee.getEmail(),
                employee.getPhoneNumber()));
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update employer by id by input json same as created json style
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        Optional<Employee> employeeData = employeeRepository.findById(id);

        if (employeeData.isPresent()){
            Employee tmpEmployee = employeeData.get();
            tmpEmployee.setEmployeeID(employee.getEmployeeID());
            tmpEmployee.setEmployeeName(employee.getEmployeeName());
            tmpEmployee.setDepartment(employee.getDepartment());
            tmpEmployee.setDateOfBirth(employee.getDateOfBirth());
            tmpEmployee.setEmail(employee.getEmail());
            tmpEmployee.setPhoneNumber(employee.getPhoneNumber());
            return new ResponseEntity<>(employeeRepository.save(tmpEmployee), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }

    //delete employee by id
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id){
        Optional<Employee> employeeData = employeeRepository.findById(id);

        if (!employeeData.isPresent()){
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
        try {
            employeeRepository.deleteById(employeeData.get().getID());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
