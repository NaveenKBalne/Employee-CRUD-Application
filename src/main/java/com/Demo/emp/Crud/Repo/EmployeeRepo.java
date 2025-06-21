package com.Demo.emp.Crud.Repo;

import com.Demo.emp.Crud.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
