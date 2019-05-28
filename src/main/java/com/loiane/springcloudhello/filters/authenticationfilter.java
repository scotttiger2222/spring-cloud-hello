package com.loiane.springcloudhello.filters;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.loiane.springcloudhello.getjson.jsonclient1;



import lombok.extern.slf4j.Slf4j;


@Component
@Order(1)
@Slf4j
public class authenticationfilter implements Filter{
	
	private jsonclient1 jsonclient1;
	


	public authenticationfilter(com.loiane.springcloudhello.getjson.jsonclient1 jsonclient1) {
		super();
		this.jsonclient1 = jsonclient1;
		
	}

	Logger	logger = LoggerFactory.getLogger(authenticationfilter.class);
	
	@Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
       
        jsonclient1.jsonclient1gettestjson();
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                logger.info("Headerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr:{}" ,headerNames.nextElement());
            }
        }    
        
        chain.doFilter(request, response);
        logger.info(
          "Logging Response Logging ResponseLogging ResponseLogging ResponseLogging ResponseLogging ResponseLogging Response:{}", 
          response.getContentType());
   }
	
	
	
	
	
	
	
}