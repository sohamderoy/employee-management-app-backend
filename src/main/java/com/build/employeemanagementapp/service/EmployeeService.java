package com.build.employeemanagementapp.service;

import com.build.employeemanagementapp.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    public EmployeeModel saveEmployeeDetails(EmployeeModel employee);

    public List<EmployeeModel> getEmployeeDetails();

    public EmployeeModel getEmployeeDetailsById(Long employeeId);

    public void deleteEmployeeDetailsById(Long employeeId);

    public EmployeeModel updateEmployeeDetails(Long employeeId, EmployeeModel employee);
}
