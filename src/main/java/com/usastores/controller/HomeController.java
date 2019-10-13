package com.usastores.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	private Logger log=Logger.getLogger(getClass());
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String init(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("init() method started");
		log.info("init() method ended");
		return "Welcome";
		
	}
	

}
