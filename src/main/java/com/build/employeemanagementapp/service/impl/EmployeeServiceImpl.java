package com.build.employeemanagementapp.service.impl;

import com.build.employeemanagementapp.model.EmployeeModel;
import com.build.employeemanagementapp.repository.EmployeeRepository;
import com.build.employeemanagementapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel saveEmployeeDetails(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeModel> getEmployeeDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeModel getEmployeeDetailsById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteEmployeeDetailsById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public EmployeeModel updateEmployeeDetails(Long employeeId, EmployeeModel employee) {
        EmployeeModel employeeInDB = employeeRepository.findById(employeeId).get();

        if(Objects.nonNull(employee.getEmpDepartment()) && !"".equalsIgnoreCase(employee.getEmpDepartment())){
            employeeInDB.setEmpDepartment(employee.getEmpDepartment());
        }
        if(Objects.nonNull(employee.getEmpName()) && !"".equalsIgnoreCase(employee.getEmpName())){
            employeeInDB.setEmpName(employee.getEmpName());
        }
        if(employee.getEmpSalary() != 0){
            employeeInDB.setEmpSalary(employee.getEmpSalary());
        }
        return employeeRepository.save(employeeInDB);
    }
}
