package com.rest.service;

import com.rest.dao.EmployeeDao;
import com.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }
    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

// My variant
//    @Override
//    @Transactional
//    public void deleteEmployee(Employee employee) {
//        employeeDAO.deleteEmployee(employee);
//    }
}
