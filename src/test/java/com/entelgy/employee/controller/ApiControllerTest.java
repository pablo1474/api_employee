package com.entelgy.employee.controller;

import com.entelgy.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ApiControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private ApiController apiController;

    @Before
    public void setUp() throws JsonProcessingException {
        Map<String, List> responseMap = new HashMap<>();
        List<String> empleadosResponse = new ArrayList<>();
        empleadosResponse.add("24,Doris Wilder");

        responseMap.put("data",empleadosResponse);

        when(employeeService.getEmployees()).thenReturn(new ResponseEntity<>(responseMap,HttpStatus.OK));

    }

    @Test
    public void getEmpleadosTest() throws JsonProcessingException {
        ResponseEntity<Object> responseEntity = apiController.getEmpleados();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}
