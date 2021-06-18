package com.fngeno.webclientdemo.service;

import com.fngeno.webclientdemo.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

import static com.fngeno.webclientdemo.constant.EmployeeConstants.*;


public class EmployeeRestClient {
    private WebClient webClient;


    private final Logger log = LoggerFactory.getLogger(EmployeeRestClient.class);

    public EmployeeRestClient(WebClient webClient) {
        this.webClient = webClient;
    }
    public List<Employee> getAllEmployees() {
        return webClient.get()
                .uri(GET_ALL_EMPLOYEES_V1)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }

//    public Employee getEmployeeById(int employeeId) {
//        //http:localhoost:8080/employeeservice/v1/employee/10
//
//        try {
//            return webClient.get()
//                    .uri(EMPLOYEE_BY_ID_PATH_PARAM_V1)
//                    .retrieve()
//                    .bodyToMono(Employee.class)
//                    .block();
//        } catch (WebClientResponseException e) {
//            log.error("Error Response code is {} and the response body is {}", e.getRawStatusCode(), e.getResponseBodyAsString());
//            log.error("WebClientResponseException in getEmployeeById ", e);
//        } catch (Exception exception) {
//            log.error("Exception in a getEmployeeById ", exception);
//        }
//        catch (Exception e){
//
//        }
//    }
}