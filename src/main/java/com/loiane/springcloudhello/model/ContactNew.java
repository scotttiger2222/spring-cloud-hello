package com.loiane.springcloudhello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ContactNew implements Serializable{
	
	
	@EmbeddedId
	private ContactNewId contactNewId;
	
	
	private String open;
	private String high;
	private String low;
	private String close;

}
