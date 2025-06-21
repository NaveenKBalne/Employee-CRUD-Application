package com.Demo.emp.Crud.Service;

import com.Demo.emp.Crud.Model.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> readEmployees();

    boolean deleteEmployee(int id);

    String updateEmployee(int id, Employee employee);

    Employee readEmployee(int id);
}
