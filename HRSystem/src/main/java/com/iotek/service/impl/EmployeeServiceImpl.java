package com.iotek.service.impl;

import com.iotek.dao.EmployeeDao;
import com.iotek.model.Employee;
import com.iotek.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    public Employee adminLogin(Employee employee) {
        if(employee==null){
            return null;
        }
        return employeeDao.getEmployeeForAdmin(employee);
    }

    public Employee login(Employee employee) {
        if(employee==null){
            return null;
        }
        return employeeDao.getEmployee(employee);
    }

    public boolean register(Employee employee) {
        if(employee==null){
            return false;
        }
        return employeeDao.addEmployee(employee);
    }
}
