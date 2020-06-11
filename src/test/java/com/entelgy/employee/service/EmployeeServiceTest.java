package com.entelgy.employee.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Before
    public void setUp(){
        RestTemplate restTemplate = new RestTemplate();
        this.employeeService = new EmployeeServiceImpl(restTemplate);
    }

    @Test
    public void contextLoads() throws JsonProcessingException {
        ResponseEntity responseEntity = employeeService.getEmployees();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

}
