package com.cache.redisImpl.services;

import com.cache.redisImpl.model.Employee;

import java.util.List;

public interface EmployeeService  {

    //String
    void setEmployeeAsString(String id, String employee);

    String getEmployee(String id);

    //List

    void addEmployeeList(Employee employee);

    List<Employee> getEmployeeList();
}
