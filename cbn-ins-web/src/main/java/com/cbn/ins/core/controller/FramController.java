package com.cbn.ins.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FramController {
	
	@RequestMapping("/index")
	public String forwordIndex(){
		return "index";
	}
}
