package com.usastores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController 
{
	@RequestMapping(value="/createStore",method=RequestMethod.GET)
	public ModelAndView addStore()
	{
		ModelAndView modelObj=new ModelAndView();
		modelObj.setViewName("AddStore");
		return modelObj;
	}
	
	@RequestMapping(value="/updateStore",method=RequestMethod.GET)
	public ModelAndView updateStore()
	{
		ModelAndView modelObj=new ModelAndView();
		modelObj.setViewName("Update");
		return modelObj;
	}
	
	@RequestMapping(value="/deleteStore",method=RequestMethod.GET)
	public ModelAndView deleteStore()
	{
		ModelAndView modelObj=new ModelAndView();
		modelObj.setViewName("Delete");
		return modelObj;
	}
	
	@RequestMapping(value="/findStore",method=RequestMethod.GET)
	public ModelAndView findAStore()
	{
		ModelAndView modelObj=new ModelAndView();
		modelObj.setViewName("Search");
		return modelObj;
	}


}
