package com.build.employeemanagementapp.controller;

import com.build.employeemanagementapp.model.EmployeeModel;
import com.build.employeemanagementapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // API to save all the employee details in DB
    @PostMapping("/employees")
    public EmployeeModel saveEmployeeDetails(@RequestBody EmployeeModel employee){
        return employeeService.saveEmployeeDetails(employee);

    }

    @GetMapping("/employees")
    public List<EmployeeModel> getEmployeeDetails(){
        return employeeService.getEmployeeDetails();
    }


    @GetMapping("/employees/{id}")
    public EmployeeModel getEmployeeDetailsById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeDetailsById(employeeId);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeDetailsById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeDetailsById(employeeId);
        return "Employee details deleted";
    }

    @PutMapping("/employees/{id}")
    public EmployeeModel updateEmployeeDetails(@PathVariable("id") Long employeeId, @RequestBody EmployeeModel employee){
        return employeeService.updateEmployeeDetails(employeeId, employee);
    }

}
