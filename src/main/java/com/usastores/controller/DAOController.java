package com.usastores.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.usastores.bean.StoreBean;
import com.usastores.cfg.SpringConfiguration;
import com.usastores.service.Service;

@Controller
public class DAOController 
{
	private Logger LOGGER=Logger.getLogger(DAOController.class);
	@Autowired
	Service service;
	
	@RequestMapping(value="/saveInTable",method=RequestMethod.POST)
	public ModelAndView saveInTable(@ModelAttribute StoreBean storeBean)
	{
		LOGGER.info("/saveInTable request "+storeBean);
		ModelAndView modelObj=new ModelAndView();
		int res= service.insert(storeBean);
		modelObj.addObject("responseObj", res+" store Added");
		modelObj.setViewName("Welcome");
		return modelObj;
		
	}
	
	@RequestMapping(value="/updateInTable",method=RequestMethod.POST)
	public ModelAndView updateInTable(@ModelAttribute StoreBean storeBean)
	{
		LOGGER.info("/updateInTable request "+storeBean);
		ModelAndView modelObj=new ModelAndView();
		int res=service.update(storeBean);
		modelObj.addObject("responseObj", res+" store Updated");
		modelObj.setViewName("Welcome");
		
		return modelObj;
		
	}
	
	@RequestMapping(value="/deleteInTable",method=RequestMethod.POST)
	public ModelAndView deleteInTable(@RequestParam("storeId") int storeId)
	{
		LOGGER.info("/deleteInTable request "+storeId);
		ModelAndView modelObj=new ModelAndView();
		int res= service.delete(storeId);
		modelObj.addObject("responseObj", res +" store Deleted");
		modelObj.setViewName("Welcome");
		
		return modelObj;
		
	}
	
	@RequestMapping(value="/findAStore",method=RequestMethod.POST)
	public ModelAndView searchInTable(@RequestParam int storeId , @RequestParam("buttonAction") String buttonVal)
	{
		LOGGER.info("/findAStore request "+storeId);
		ModelAndView modelObj=new ModelAndView();
		List<StoreBean> listRes=service.search(storeId);
		modelObj.addObject("ListResponse", listRes);
		LOGGER.info("/saveInTable request "+listRes);
		if(buttonVal.equalsIgnoreCase("search"))
		{
		modelObj.setViewName("Search");
		}
		else
			modelObj.setViewName("Update");
		
		return modelObj;
		
	}
	@RequestMapping(value= "/findAStore/{storeId}",method=RequestMethod.GET)    
    public ModelAndView greet(@PathVariable int storeId, ModelMap model){
		LOGGER.info("/findAStore path request "+storeId);
		ModelAndView modelObj=new ModelAndView();
		List<StoreBean> listRes=service.search(storeId);
		modelObj.addObject("ListResponse", listRes);
		LOGGER.info("/saveInTable request "+listRes);
		modelObj.setViewName("SearchStore");
		return modelObj;
    }

}
