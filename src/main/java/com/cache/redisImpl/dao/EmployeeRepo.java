package com.cache.redisImpl.dao;

import com.cache.redisImpl.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {

    //String
    void setEmployeeAsString(String id, String employee);

    String getEmployee(String id);

    //List

    void addEmployeeList(Employee employee);

    List<Employee> getEmployeeList();

}
