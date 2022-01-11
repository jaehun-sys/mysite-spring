package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	String home() {
		System.out.println(">>> "+this.getClass()+" 호출됨!");
		return "main/index";
	}
}
