package com.cache.redisImpl.controller;

import com.cache.redisImpl.model.Employee;
import com.cache.redisImpl.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee/add")
    public void addEmployee(@RequestBody Employee employee) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        employeeService.setEmployeeAsString(String.valueOf(employee.getId()), objectMapper.writeValueAsString(employee));
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }
}
