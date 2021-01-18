package com.bitacademy.mysite.initializer;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bitacademy.mysite.config.AppConfig;
import com.bitacademy.mysite.config.WebConfig;

public class MySiteWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context Config
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Application Context Config
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// DispatcherServlet Mapping
		return new String[] { "/" };
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		
		// create DispatcherServlet
		DispatcherServlet dispatcherServlet = (DispatcherServlet)super.createDispatcherServlet(servletAppContext);
	
		// Exception Handler가 없으면 Exception을 throw하게 설정
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
}