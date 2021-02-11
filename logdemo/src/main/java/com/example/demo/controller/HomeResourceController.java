package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeResourceController {

    Logger logger = LoggerFactory.getLogger(HomeResourceController.class);

    @RequestMapping("/home")
    public String home(){
        logger.trace("Home method accessed");
        return "Hello from Frank again " + logger;
    }

}
