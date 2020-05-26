package com.uca.capas.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/index")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		return mav;

	}
	
	
}
