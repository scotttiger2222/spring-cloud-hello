package com.loiane.springcloudhello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loiane.springcloudhello.model.Contact;
import com.loiane.springcloudhello.model.ContactNew;
import com.loiane.springcloudhello.model.ContactNewId;

@Repository
public interface ContactNewRepository extends JpaRepository<ContactNew, ContactNewId>{

}
