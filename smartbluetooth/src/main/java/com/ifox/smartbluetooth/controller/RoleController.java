package com.ifox.smartbluetooth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class RoleController {
	
	@RequestMapping("/mvc")
	public String helloMvc() {
		System.out.println("===========================dhiuhiuhiuhi");
		return "hello";
		
	}

}
