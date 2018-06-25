package com.wine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@GetMapping("/novo")
	public String novo() {
		return "vinhos/cadastro-vinho";
	}

}
