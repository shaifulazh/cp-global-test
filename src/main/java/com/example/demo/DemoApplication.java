package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    @Bean
    public CommandLineRunner run(EmployeeRepository emplyeeRepo) throws Exception {
        return (String[] args) -> {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = "2014-02-11";
			Date dob = sdf.parse(dateString);
			Employee employee1 = new Employee(null, "Sultan", "kambing", null, dob, null, null);
			emplyeeRepo.save(employee1);
			emplyeeRepo.findAll().forEach(employee -> System.out.println(employee.getEmployeeName() + " time : "+ employee.getDateOfBirth()));
        };
    }
}
