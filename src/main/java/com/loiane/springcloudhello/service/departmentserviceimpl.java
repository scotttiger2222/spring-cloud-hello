package com.loiane.springcloudhello.service;

import java.util.List;
import com.loiane.springcloudhello.repository.departmentrepository;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.loiane.springcloudhello.repository.departmentcustomrepository;

import com.loiane.springcloudhello.model.department;

@Service
public class departmentserviceimpl  implements departmentservice{

	departmentrepository departmentrepository;
	departmentcustomrepository departmentcustomrepository;
	
	
	public departmentserviceimpl(com.loiane.springcloudhello.repository.departmentrepository departmentrepository, departmentcustomrepository departmentcustomrepository) {
		super();
		this.departmentrepository = departmentrepository;
		this.departmentcustomrepository=departmentcustomrepository;
	}


	  @Cacheable(value="cloudhellocache",key="#id",unless="#result==null")
	  public department save(department department) {
	    
		return departmentrepository.save(department);
	  }
	
	
	  @Cacheable(value="cloudhellocache",unless="#result==null")
	  public  List findAll(){
		
		  return departmentrepository.findAll(); 
	  }
	  
	
	  @Cacheable(value="cloudhellocache",key="#id",unless="#result==null")
	  public Optional<department> findById(Integer id){
		
		  return departmentrepository.findById(id);
	  }
	 
	  
	  @CacheEvict(value="cloudhellocache",key="#id")
	  public void deleteById(Integer id){
			
		  departmentrepository.deleteById(id); 
	  }
	  
	  
	  public department finddepartmentbydeptnoanddepartmentnamenamedparams( Integer deptno, 
			  String departmentname) { 
		  
	return	  departmentcustomrepository.finddepartmentbydeptnoanddepartmentnamenamedparams(deptno,departmentname);
		  }
	
	    
	  public	List<Object> fetchdeptempdataleftjoin(){
		
		return departmentcustomrepository.fetchdeptempdataleftjoin();
	}
 
	  
	  
}
