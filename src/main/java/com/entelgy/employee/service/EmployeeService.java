package com.entelgy.employee.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    public ResponseEntity getEmployees() throws JsonProcessingException;
}
