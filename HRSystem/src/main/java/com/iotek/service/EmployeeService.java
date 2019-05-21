package com.iotek.service;

import com.iotek.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee adminLogin(Employee employee);//管理员登录判断账号类型
    Employee login(Employee employee);//正常员工登录
    boolean register(Employee employee);//管理员注册正常操作，员工账号由管理员直接注册好分配
    Employee getEmployeeByPosId(Integer pos_id);
    boolean updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Integer emp_id);
}
