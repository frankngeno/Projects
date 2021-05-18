package com.fngeno.webclientdemo.service;

import com.fngeno.webclientdemo.dto.Employee;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.fngeno.webclientdemo.constant.EmployeeConstants.GET_ALL_MOVIES_V1;

public class EmployeeRestClient {
    private WebClient webClient;

    public  EmployeeRestClient(WebClient webClient){
        this.webClient = webClient;
    }

    //http:localhoost:8080/employeeservice/v1/allEmployees
    public List<Employee> getAllEmployees(){
       return webClient.get()
                .uri(GET_ALL_MOVIES_V1)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
               .block();
    }

}
