package com.Demo.emp.Crud.Service;

import com.Demo.emp.Crud.Entity.EmployeeEntity;
import com.Demo.emp.Crud.Model.Employee;
import com.Demo.emp.Crud.Repo.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepo.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeRepo.findAll();
        List<Employee> employee = new ArrayList<>();

        for (EmployeeEntity employeeEntity: employeeList){
            Employee emp= new Employee();

//            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setNumber(employeeEntity.getNumber());
            emp.setEmail(employeeEntity.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) {
//        employees.remove(id);
        EmployeeEntity emp =employeeRepo.findById(id).get();
        employeeRepo.delete(emp);
        return true;
    }

    public String updateEmployee(int id, Employee employee){
        EmployeeEntity existingEmployee = employeeRepo.findById(id).get();

        existingEmployee.setName(employee.getName());
        existingEmployee.setNumber(employee.getNumber());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepo.save(existingEmployee);
        return "Updated Successfully";

    }

    @Override
    public Employee readEmployee(int id) {
        EmployeeEntity existingEmployee = employeeRepo.findById(id).get();
        Employee employee= new Employee();
        BeanUtils.copyProperties(existingEmployee, employee);
        return employee;
    }
}
