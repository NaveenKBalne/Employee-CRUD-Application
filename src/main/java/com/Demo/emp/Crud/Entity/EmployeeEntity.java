package com.Demo.emp.Crud.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
@Entity
@Table(name ="Emp_db")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String number;
    private String Email;
}
