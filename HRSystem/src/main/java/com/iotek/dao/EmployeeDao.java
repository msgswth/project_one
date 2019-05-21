package com.iotek.dao;

import com.iotek.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployeeForAdmin(Employee employee);
    Employee getEmployee(Employee employee);
    boolean addEmployee(Employee employee);
    Employee getEmployeeByPosId(Integer pos_id);
    Employee getEmployeeById(Integer emp_id);
    boolean updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
}
