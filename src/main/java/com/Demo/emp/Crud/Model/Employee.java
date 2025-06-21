package com.Demo.emp.Crud.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int Id;
    private String Name;
    private String number;
    private String Email;

}
