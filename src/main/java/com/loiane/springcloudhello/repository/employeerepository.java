package com.loiane.springcloudhello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loiane.springcloudhello.model.department;
import com.loiane.springcloudhello.model.employee;

@Repository
public interface employeerepository extends JpaRepository<employee, Long>{

}
