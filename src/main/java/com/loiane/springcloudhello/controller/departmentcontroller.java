package com.loiane.springcloudhello.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.loiane.springcloudhello.model.department;
import com.loiane.springcloudhello.model.employee;
import com.loiane.springcloudhello.repository.departmentrepository;
import com.loiane.springcloudhello.repository.employeerepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/department")
public class departmentcontroller {

	private departmentrepository deptrepository;
	
	Logger	logger = LoggerFactory.getLogger(departmentcontroller.class);
		
	public departmentcontroller(departmentrepository deptrepository) {
		super();
		this.deptrepository = deptrepository;
	}

	@GetMapping
    public List findAll(){
    	
	/*	deptrepository.save(new department(10, "ACCOUNTING", "NEW YORK"));
		deptrepository.save(new department(20, "RESEARCH", "DALLAS"));
		deptrepository.save(new department(30, "SALES", "CHICAGO"));
	*/	
    	
		
		
		
        return deptrepository.findAll();
    }

	
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<department> findById(@PathVariable Integer id){
     
    	try {
    /*	return deptrepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
   
    */	
    	
    	ResponseEntity<department>	finddepartment= deptrepository.findById(id)
                    .map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());
    	
    	logger.info("::::::::::::::::::::"+"----------------------------------"+finddepartment);
    	
    		if (!finddepartment.hasBody()) {logger.info("----------------------------------"+"inside if block");	throw new Exception();}
    		else return finddepartment;
    		
    	}
    	
    	catch (Exception exc) {
    		logger.info("----------------------------------"+"came to catch block");		
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found", exc);
       }
    	
    	
	}
	
	
    
    @PostMapping
    department newdepartment(@RequestBody department newdepartment) {
       return deptrepository.save(newdepartment);
    }
    
    
  
    
    
    @PutMapping("/{id}")
    department replacedepartment(@RequestBody department newdepartment, @PathVariable Integer id) {

      return deptrepository.findById(id)
        .map(department -> {
        	department.setLoc(newdepartment.getLoc());
        	department.setDepartmentname(newdepartment.getDepartmentname());
          return deptrepository.save(newdepartment);
        })
        .orElseGet(() -> {
        	newdepartment.setDeptno(id);
          return deptrepository.save(newdepartment);
        });
    }
    
    
    @DeleteMapping("/{id}")
    void deletedepartment(@PathVariable Integer id) {
      deptrepository.deleteById(id);
    }
    
	
	
}
