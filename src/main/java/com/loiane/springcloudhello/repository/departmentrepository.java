package com.loiane.springcloudhello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loiane.springcloudhello.model.Contact;
import com.loiane.springcloudhello.model.department;

@Repository
public interface departmentrepository extends JpaRepository<department, Long>{

}
