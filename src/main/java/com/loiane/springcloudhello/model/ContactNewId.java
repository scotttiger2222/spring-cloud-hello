package com.loiane.springcloudhello.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ContactNewId implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	  @Column(name = "date")
	  private String date;
	  
	  @Column(name = "symbol")
	  private String symbol;
	
	
	
}
