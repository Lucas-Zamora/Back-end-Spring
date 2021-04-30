package com.hello2.hello2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aprendizagem")
public class Hello2Controller {
	@GetMapping
	public String hello2() {
		return "Foco na semana: Aprender Spring boot, e aprimorar conhecimentos java e mysql";
	}
}
