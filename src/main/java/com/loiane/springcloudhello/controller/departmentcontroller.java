package com.loiane.springcloudhello.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;


import com.loiane.springcloudhello.model.department;
import com.loiane.springcloudhello.model.employee;
import com.loiane.springcloudhello.repository.departmentrepository;
import com.loiane.springcloudhello.repository.departmentcustomrepository;
import com.loiane.springcloudhello.repository.employeerepository;
import com.loiane.springcloudhello.service.departmentserviceimpl;
import com.loiane.springcloudhello.config.yamlconfig;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.loiane.springcloudhello.getjson.jsonclient1;

@Slf4j
@RestController
@RequestMapping("/department")
public class departmentcontroller {

	private departmentrepository deptrepository;
	private departmentserviceimpl        deptserviceimpl;
	private departmentcustomrepository departmentcustomrepository;
	private com.loiane.springcloudhello.getjson.jsonclient1 jsonclient1;
	private yamlconfig yamlconfig;
	
	
	
	
	Logger	logger = LoggerFactory.getLogger(departmentcontroller.class);
		
 public departmentcontroller(departmentrepository deptrepository ,departmentserviceimpl deptserviceimpl,departmentcustomrepository departmentcustomrepository, jsonclient1 jsonclient1, yamlconfig yamlconfig) {
		super();
		this.deptrepository = deptrepository;
		this.deptserviceimpl= deptserviceimpl;
		this.departmentcustomrepository=departmentcustomrepository;
		this.jsonclient1 = jsonclient1;
		this.yamlconfig=yamlconfig;
	}

	@GetMapping
    public List findAll(){
    	
	/*DATA INSERT IN DEPARTMENT TABLE FROM DEPRTMENT ENTITIY AND REPOSITORY
	 * 
	 * 	deptrepository.save(new department(10, "ACCOUNTING", "NEW YORK"));
		deptrepository.save(new department(20, "RESEARCH", "DALLAS"));
		deptrepository.save(new department(30, "SALES", "CHICAGO"));
	*/	
		
//ENABLING READ FROM YML FILE AND APPLICATION.PROPERTIES 
  
		logger.info("yamlfile::::::::::::::::::::"+"----------------------------------"+yamlconfig.getEnvironment());
		logger.info("yamlfile::::::::::::::::::::"+"----------------------------------"+yamlconfig.getName());
		logger.info("yamlfile::::::::::::::::::::"+"----------------------------------"+yamlconfig.getServers());
		logger.info("apppropfile:::::::::::::::::"+"----------------------------------"+yamlconfig.getValueFromFile());
		
		jsonclient1.jsonclient1gettestjson();
		
		
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
    	
 //   	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
 //       HttpSession mySession=   attr.getRequest().getSession();
//      String s=  (String) mySession.getAttribute("jim");
//        logger.info(">>>>>>>>>>>>>>>>>>>>"+s);
    	
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
       
/*	   deptrepository.save(new department(60,"ADVERTISING","TEXAS"));
   	deptrepository.save(new department(70,"ADVERTISING1","TEXAS1"));
   	deptrepository.save(new department(120,"ADVERTISING2","TEXAS2"));
   	
    	
    	
    	return deptrepository.save(newdepartment);
   */
	   
	   return deptserviceimpl.save(newdepartment);
	   
    	
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
    
	
    
    
    
    @GetMapping(path = {"/{deptno}/{departmentname}"})
    department finddepartmentbydeptnoanddepartmentnamenamedparams(@PathVariable Integer deptno, @PathVariable String departmentname ) {
    	
    	return departmentcustomrepository.finddepartmentbydeptnoanddepartmentnamenamedparams(deptno, departmentname);
    	
    	
    }
    
    
    
    
    @GetMapping("/joinfindalldepartmentandtheiremployee")
    List <Object> joinfindalldepartmentandtheiremployeebydeptnonamedparams() {
    	
                 return  departmentcustomrepository.fetchdeptempdataleftjoin();
    	
    	
    }
    
    
    
	
}
