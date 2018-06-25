package com.wine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wine.model.TipoVinho;
import com.wine.model.Vinho;
import com.wine.repository.Vinhos;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;

	@GetMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("vinhos/cadastro-vinho");
		mv.addObject("vinho", vinho);
		mv.addObject("tipos", TipoVinho.values());

		return mv;
	}

	@PostMapping("/novo")
	public String cadastrar(Vinho vinho) {
		vinhos.save(vinho);

		return "redirect:/vinhos/novo";
	}

	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(vinhos.getOne(id));
	}
}
