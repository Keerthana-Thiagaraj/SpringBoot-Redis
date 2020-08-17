package com.cache.redisImpl.services;

import com.cache.redisImpl.dao.EmployeeRepo;
import com.cache.redisImpl.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void setEmployeeAsString(String id, String employee) {
        employeeRepo.setEmployeeAsString(id, employee);
    }

    @Override
    public String getEmployee(String id) {
        return employeeRepo.getEmployee(id);
    }

    @Override
    public void addEmployeeList(Employee employee) {
        employeeRepo.addEmployeeList(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepo.getEmployeeList();
    }
}
