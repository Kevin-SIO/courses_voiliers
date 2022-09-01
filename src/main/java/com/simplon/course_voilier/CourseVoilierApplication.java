package com.simplon.course_voilier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class CourseVoilierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseVoilierApplication.class, args);
	}

}
