package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Employee;
import com.calisto.spring.rest_api.service.company.CompanyService;
import com.calisto.spring.rest_api.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAll();
        return employeeList;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.addEmployee(employee);
        return emp;
    }

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "Удалено!";
    }

    @PostMapping("/edit")
    public Employee editEmployee(@RequestBody Employee employee){
        Employee empl = employeeService.editEmployee(employee);
        return empl;
    }
}
