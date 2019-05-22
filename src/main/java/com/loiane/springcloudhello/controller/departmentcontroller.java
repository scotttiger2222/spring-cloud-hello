package com.loiane.springcloudhello.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loiane.springcloudhello.model.department;
import com.loiane.springcloudhello.model.employee;
import com.loiane.springcloudhello.repository.departmentrepository;
import com.loiane.springcloudhello.repository.employeerepository;

@RestController
@RequestMapping({"/department"})
public class departmentcontroller {

	private departmentrepository deptrepository;
		
	public departmentcontroller(departmentrepository deptrepository) {
		super();
		this.deptrepository = deptrepository;
	}

	@GetMapping
    public List findAll(){
    	
		deptrepository.save(new department(10, "ACCOUNTING", "NEW YORK"));
		deptrepository.save(new department(20, "RESEARCH", "DALLAS"));
		deptrepository.save(new department(30, "SALES", "CHICAGO"));
		
    	
		
		
		
        return deptrepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<department> findById(@PathVariable long id){
        return deptrepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
	
	
	
	
}
