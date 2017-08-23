package com.csy.module.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexAction {

	@RequestMapping("/{account}/cZone")
	public ModelAndView accountIndex(@PathVariable String account){
		return new ModelAndView("cZone");
	}
	
	@RequestMapping("/index")
	public ModelAndView index(String account){
		return new ModelAndView("index");
	}
}