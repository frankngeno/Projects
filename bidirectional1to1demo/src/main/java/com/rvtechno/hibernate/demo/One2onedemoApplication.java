package com.rvtechno.hibernate.demo;

import com.rvtechno.hibernate.demo.entity.Instructor;
import com.rvtechno.hibernate.demo.entity.InstructorDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class One2onedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(One2onedemoApplication.class, args);
	}

	Instructor instructor = new Instructor("chad", "doe", "chad@gmail.com");

	InstructorDetail instructorDetail = new InstructorDetail();
}
