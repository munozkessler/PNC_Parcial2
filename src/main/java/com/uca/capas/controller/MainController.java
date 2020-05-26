package com.uca.capas.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.capas.domain.Categoria;
import com.uca.capas.service.CategoriaService;

@Controller
public class MainController {

	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		return mav;

	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresarCategoria() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		
		mav.setViewName("ingresarCategoria");
		return mav;

	}
	
	@RequestMapping("/formCategoria")
	public ModelAndView formCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			
			mav.setViewName("ingresarCategoria");
		}
		else {
			
		    categoriaService.save(categoria);
		    mav.addObject("categoriaIngresada", true);
			mav.setViewName("index");
		}
		
		
		return mav;

	}
	
	
}
