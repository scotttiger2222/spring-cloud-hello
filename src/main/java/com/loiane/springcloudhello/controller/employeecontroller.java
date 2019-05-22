package com.loiane.springcloudhello.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loiane.springcloudhello.model.Contact;
import com.loiane.springcloudhello.model.ContactNew;
import com.loiane.springcloudhello.model.ContactNewId;
import com.loiane.springcloudhello.model.employee;
import com.loiane.springcloudhello.repository.employeerepository;

@RestController
@RequestMapping({"/employee"})
public class employeecontroller {

	private employeerepository emprepository;

	public employeecontroller(employeerepository emprepository) {
		super();
		this.emprepository = emprepository;
	}
	
	
	@GetMapping
    public List findAll(){
    	
		
		
		
		 emprepository.save(new employee(7839, "KING", "PRESIDENT", 0,5000, 10));
			emprepository.save(new employee(7698, "BLAKE", "MANAGER",7839, 2850, 30));
			emprepository.save(new employee(7782, "CLARK", "MANAGER", 7839,2450,  10));
			emprepository.save(new employee(7566, "JONES", "MANAGER", 7839,2975,  20));
			emprepository.save(new employee(7788, "SCOTT", "ANALYST", 7566,3000,  20));
			emprepository.save(new employee(7902, "FORD", "ANALYST", 7566,3000,  20));
			emprepository.save(new employee(7499, "ALLEN", "SALESMAN", 7698,1600,  30));
			emprepository.save(new employee(7521, "WARD", "SALESMAN", 7698,1250,  30));
			emprepository.save(new employee(7876, "ADAMS", "CLERK", 7788, 1100,  20));
			emprepository.save(new employee(7900, "JAMES", "CLERK", 7698, 950,  30));
				
    	
        return emprepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<employee> findById(@PathVariable long id){
        return emprepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
	
	
	
	
}
