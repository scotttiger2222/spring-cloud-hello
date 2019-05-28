package com.loiane.springcloudhello.exceptionhandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.hibernate.exception.SQLGrammarException;

import com.loiane.springcloudhello.controller.departmentcontroller;

import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@RestControllerAdvice
@Slf4j
public class restcontrolleradvice {

	Logger	logger = LoggerFactory.getLogger(restcontrolleradvice.class);
	
	@ExceptionHandler(NullPointerException.class)
	  public responsemsg handleNotFoundException(NullPointerException ex) {
		responsemsg responsemsg = new responsemsg("no service available for now");
	    return responsemsg;
	  }
	
	
	
	@ExceptionHandler(SQLException.class)
	  public responsemsg handleNotFoundException(SQLException ex) {
		
		logger.error("SQLException--------------------------------------------------- :{}" + ex);
		responsemsg responsemsg = new responsemsg("SQL Exception Occuring in the Code");
	    return responsemsg;
	  }
	
	
	
	@ExceptionHandler(SQLGrammarException.class)
	  public responsemsg handleNotFoundException(SQLGrammarException ex) {
		
		logger.error("SQLException--------------------------------------------------- :{}" + ex);
		responsemsg responsemsg = new responsemsg("SQL Exception Occuring in the Code");
	    return responsemsg;
	  }
	
	
	
}
