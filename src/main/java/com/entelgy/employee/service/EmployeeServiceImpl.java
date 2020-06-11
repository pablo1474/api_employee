package com.entelgy.employee.service;

import com.entelgy.employee.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.scanner.Constant;

import java.sql.Struct;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity getEmployees() throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        ResponseEntity<String> response = restTemplate.exchange(Constants.urlEmployees, HttpMethod.GET, new HttpEntity<>(null,headers),String.class);
        String responseBody = (response.getBody() != null) ? response.getBody() : "";

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = objectMapper.readValue(responseBody, Map.class);

        List<Map<String, String>> listEmployees = (List<Map<String, String>>) map.get("data");

        List<String> empleadosResponse = new ArrayList<>();
        for(Map<String, String> listaEmpleados : listEmployees){
            empleadosResponse.add(listaEmpleados.get("id")+","+listaEmpleados.get("employee_name"));
        }

        Map<String,List> responseMap = new HashMap<>();
        responseMap.put("data",empleadosResponse);

        return new ResponseEntity(responseMap, HttpStatus.OK);
    }

}
