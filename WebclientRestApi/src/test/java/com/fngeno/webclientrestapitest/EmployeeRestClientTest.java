package com.fngeno.webclientrestapitest;

import com.fngeno.webclientrestapi.dto.Employee;
import com.fngeno.webclientrestapi.service.EmployeeRestClient;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class EmployeeRestClientTest {
    private static final String baseUrl = "//http:localhost:8081/employeeService/v1/allEmployees";

    private WebClient webClient = WebClient.create(baseUrl);
    EmployeeRestClient employeeRestClient = new EmployeeRestClient(webClient);

    @Test
    void getAllEmployees() {
        List<Employee> employeeList = employeeRestClient.getAllEmployees();
        assertTrue(employeeList.size() > 0);
    }
//
//    @Test
//    void getEmployeeById() {
//        int employeeId = 1;
//        Employee employee = employeeRestClient.getEmployeeById(employeeId);
//        assertEquals("frank", employee.getFirstName());
//    }

}