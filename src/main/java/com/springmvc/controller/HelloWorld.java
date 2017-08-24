package com.springmvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.User;

@Controller
public class HelloWorld {

	@RequestMapping("/helloworld1/{id}")
	public String hello(@PathVariable(value="id") int id)
	{
		System.out.println("hello world");
		System.out.println("this paramater is :"+id);
		return "success";
	}
	
	@RequestMapping("/helloworld")
	public String hello1()
	{
		return "success";
	}
	
	@RequestMapping("/helloworld2")
	public String testRequestParam(@RequestParam(value="username") String username, @RequestParam(value="age", required=false, defaultValue="0") int age){
	    System.out.println("testRequestParam" + " username:" + username + " age:" +age);
	    return "success";
	}
	
	@RequestMapping("/testpojo")
	public String testpojo(User user)
	{
		 System.out.println("testPojo: " + user);
		    return "success";
	}
	
	@RequestMapping("/testmodelandview")
	public ModelAndView testModelAndView()
	{
		String viewname="modelandview";
		ModelAndView mv=new ModelAndView(viewname);
		mv.addObject("time", new Date());
		return mv;
		
	}
}
