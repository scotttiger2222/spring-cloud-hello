package com.loiane.springcloudhello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.loiane.springcloudhello.model.department;
import com.loiane.springcloudhello.repository.departmentrepository;

@Service
public interface departmentservice{

	 public department save(department department); 

	  public  List findAll();
	  
	  public Optional<department> findById(Integer id);
	 
	  public void deleteById(Integer id);
	
	  public department finddepartmentbydeptnoanddepartmentnamenamedparams( Integer deptno, String departmentname) ; 
		  
	  public	List<Object> fetchdeptempdataleftjoin();
}
