package com.example.resume_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.resume_system_application",
		"com.example.resume_system"
})
public class ResumeSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumeSystemApplication.class, args);
    }
}
