package com.loiane.springcloudhello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class employee {
	
	
	
	
	    @Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int empno;
	    private String ename;
	    private String job;
	    private int mgr ;
	    private int sal;
	    private int deptno;
	  
	    
	
	    

}
