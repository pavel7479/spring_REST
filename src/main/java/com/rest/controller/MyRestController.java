package com.rest.controller;

import com.rest.entity.Employee;
import com.rest.exseption_handling.EmployeeIncorrectData;
import com.rest.exseption_handling.NoSuchEmployeeException;
import com.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no such employee with Id = " + id + " in Database");
        }
        return employee;
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(Exception exception) {
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }
}
