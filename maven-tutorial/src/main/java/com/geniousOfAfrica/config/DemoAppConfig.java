package com.geniousOfAfrica.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.geniusOfAfrica.maven-tutorial")
public class DemoAppConfig implements WebMvcConfigurer {

}
