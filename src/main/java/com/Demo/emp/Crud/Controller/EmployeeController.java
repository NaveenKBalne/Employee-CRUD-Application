package com.Demo.emp.Crud.Controller;
import com.Demo.emp.Crud.Entity.EmployeeEntity;
import com.Demo.emp.Crud.Model.Employee;
import com.Demo.emp.Crud.Repo.EmployeeRepo;
import com.Demo.emp.Crud.Service.EmployeeService;
import com.Demo.emp.Crud.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

//    EmployeeService employeeService = new EmployeeServiceImpl();
//
    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getEmployee(){

        return employeeService.readEmployees();

//        Employee emp = new Employee();
//        emp.setId(402);
//        emp.setName("Naveen Kumar");
//        emp.setNumber("6300929130");
//        emp.setEmail("Naveenkumar1212000@gmail.com");
//
//        return employees;
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        //        employees.add(employee);
        return "Saved Successfully";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(employeeService.deleteEmployee(id))
                return "Deleted Successfully";
        return "Not found";

    }

    @PutMapping("employees/{id}")
    public String putMethod(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
}
