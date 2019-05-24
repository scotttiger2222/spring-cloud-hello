package com.loiane.springcloudhello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.loiane.springcloudhello.model.department;

@Repository
public interface departmentcustomrepository extends JpaRepository<department, Integer> {

	@Query("SELECT d FROM department d WHERE d.deptno = :deptno and d.departmentname = :departmentname")
	  public department finddepartmentbydeptnoanddepartmentnamenamedparams(@Param("deptno") Integer deptno, 
			  @Param("departmentname") String departmentname);
	
}
