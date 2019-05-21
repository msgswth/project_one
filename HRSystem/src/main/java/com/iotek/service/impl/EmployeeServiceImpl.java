package com.iotek.service.impl;

import com.iotek.dao.EmployeeDao;
import com.iotek.model.Employee;
import com.iotek.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public Employee getEmployeeByPosId(Integer pos_id) {
        if(pos_id==null||pos_id==0){
            return null;
        }
        return employeeDao.getEmployeeByPosId(pos_id);
    }

    public boolean updateEmployee(Employee employee) {
        if(employee==null){
            return false;
        }
        return employeeDao.updateEmployee(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    public Employee getEmployeeById(Integer emp_id) {
        if (emp_id == null || emp_id==0) {
            return null;
        }
        return employeeDao.getEmployeeById(emp_id);
    }
}
