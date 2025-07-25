package com.Tcs.springboot_docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class SpringBootController {
	
	@GetMapping("/welocme")
    public String welcome() {
        return "Welcome to Spring Boot Application!";
    }
}
