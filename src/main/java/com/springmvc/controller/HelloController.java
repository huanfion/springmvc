package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("message", "hello everyone!");
		modelandview.setViewName("hello");
		return modelandview;
	}
}
