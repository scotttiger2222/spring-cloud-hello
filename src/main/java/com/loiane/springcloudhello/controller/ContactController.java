package com.loiane.springcloudhello.controller;

import com.loiane.springcloudhello.model.Contact;
import com.loiane.springcloudhello.model.ContactNew;
import com.loiane.springcloudhello.model.ContactNewId;
import com.loiane.springcloudhello.repository.ContactNewRepository;
import com.loiane.springcloudhello.repository.ContactRepository;
import com.loiane.springcloudhello.repository.departmentrepository;
import com.loiane.springcloudhello.repository.employeerepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.LongStream;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

    private ContactRepository repository;
    private ContactNewRepository newrepository;
    
   
    

    ContactController(ContactRepository contactRepository,ContactNewRepository contactnewrepository) {
        this.repository = contactRepository;
        this.newrepository=contactnewrepository;
    }

    @GetMapping
    public List findAll(){
    	
    	newrepository.save(new ContactNew(new ContactNewId("20170203","ACC"),"open","high","low","close"));
    	
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }



    

	



}
