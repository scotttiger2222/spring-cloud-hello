package com.loiane.springcloudhello.repository;

import java.lang.annotation.Native;
import java.util.List;

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
	
	@Query(value ="SELECT d.deptno,d.departmentname,d.loc,e.empno, e.ename, e.job,e.mgr,e.sal " + 
			"FROM department d LEFT JOIN employee e on d.deptno=e.deptno",nativeQuery = true)       
	
	
		List<Object> fetchdeptempdataleftjoin();

}
