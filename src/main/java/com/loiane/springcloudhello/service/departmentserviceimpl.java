package com.loiane.springcloudhello.service;

import java.util.List;
import com.loiane.springcloudhello.repository.departmentrepository;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.loiane.springcloudhello.model.department;

@Service
public class departmentserviceimpl  implements departmentservice{

	departmentrepository departmentrepository;
	
	
	public departmentserviceimpl(com.loiane.springcloudhello.repository.departmentrepository departmentrepository) {
		super();
		this.departmentrepository = departmentrepository;
	}



	  public department save(department department) {
	    
	
		
		return departmentrepository.save(department);
	  }
	
	
	
}
