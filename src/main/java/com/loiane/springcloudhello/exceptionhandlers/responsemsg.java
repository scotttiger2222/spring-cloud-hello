package com.loiane.springcloudhello.exceptionhandlers;

public class responsemsg {
	  private String message;
	  
	  public responsemsg(String msg){
	    this.message = msg;
	  }
	  
	  public String getMessage() {
	    return message;
	  }
	 
	  public void setMessage(String message) {
	    this.message = message;
	  }
	}
