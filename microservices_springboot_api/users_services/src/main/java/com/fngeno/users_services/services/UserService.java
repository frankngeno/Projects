package com.fngeno.users_services.services;

import com.fngeno.user.controller.UserController;
import com.fngeno.user.entity.User;
import com.fngeno.user.repository.UserRepository;
import com.fngeno.user.valueobjects.Department;
import com.fngeno.user.valueobjects.ResponseTemplateMapper;
import com.fngeno.users_services.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    //private Logger log = LoggerFactory.getLogger(UserService.class);

    public User saveUser(User user) {
       // log.info("Inside saveUser userService");
        return userRepository.save(user);
    }

    public ResponseTemplateMapper getUserAndDepartment(Long userId) {
       // log.info("Inside getUserAndDepartment of UserService");
        ResponseTemplateMapper templateMapper = new ResponseTemplateMapper();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                , Department.class);
        templateMapper.setUser(user);
        templateMapper.setDepartment(department);
        return templateMapper;

    }
}