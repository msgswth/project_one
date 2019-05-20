package com.iotek.dao;

import com.iotek.model.Employee;

public interface EmployeeDao {
    Employee getEmployeeForAdmin(Employee employee);
    Employee getEmployee(Employee employee);
    boolean addEmployee(Employee employee);
    Employee getEmployeeByPosId(Integer pos_id);
}
