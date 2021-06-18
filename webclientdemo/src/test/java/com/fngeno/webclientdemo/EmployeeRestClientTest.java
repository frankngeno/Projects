package com.fngeno.webclientdemo;

import com.fngeno.webclientdemo.dto.Employee;
import com.fngeno.webclientdemo.service.EmployeeRestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
//
//    @Test
//
//    void getEmployeeById_notFound() {
//        int employeeId = 10;
//        Assertions.assertThrows(WebClientResponseException.class, () -> employeeRestClient.getEmployeeById(employeeId));
//    }
}