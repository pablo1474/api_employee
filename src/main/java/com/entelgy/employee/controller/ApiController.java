package com.entelgy.employee.controller;

import com.entelgy.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api")
public class ApiController {

    private final EmployeeService employeeService;

    @Autowired
    public ApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/empleados")
    public ResponseEntity getEmpleados() throws JsonProcessingException {
        return employeeService.getEmployees();
    }
}
