package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidade e mentalidade")
public class HelloController {
	
	@GetMapping
	public String hello() {
		return "Habilidade: Persistencia e Mentalidade: Crescimento";
	}
}
