package com.loiane.springcloudhello.filters;

import java.io.IOException;

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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class RequestResponseLoggingFilter implements Filter {
 
	Logger	logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
	
	
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info(
          "Logging Request  {{{{{{{{{{{{{{{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}} : {}", req.getMethod(), 
          req.getRequestURI());
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession mySession=   attr.getRequest().getSession(true);
        mySession.setAttribute("jim", "carry");
        
        req.getRequestDispatcher(((HttpServletRequest) request).getRequestURI()).forward(req, res);
        
    }

	
	}
 
    
