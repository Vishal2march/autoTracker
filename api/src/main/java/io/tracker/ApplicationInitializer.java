package io.tracker;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// A dispatcher Servlet class which is in connection with Configuration class.
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
	
		// An array of Class which holds Application & JPA class
		return new Class[]{Application.class, JPAConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	
		return new Class[0];
	}

	@Override
	protected String[] getServletMappings() {
		
		//it has a starting api url path endpoint
		return new String[]{"/webapi/*"};
	}

}
