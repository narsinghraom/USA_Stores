package com.usastores.cfg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*
Web.xml configuration by replacing the below code.
*/
public class WebServletConfiguration implements WebApplicationInitializer{
	private Logger LOGGER=Logger.getLogger(WebServletConfiguration.class);
	
	public void onStartup(ServletContext ctx) throws ServletException {
		LOGGER.info("onStartup method started");
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(SpringConfiguration.class);
        webCtx.setServletContext(ctx);
        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        LOGGER.info("onStartup method Ended");
    }

}
