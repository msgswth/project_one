package com.iotek.controller;

import com.iotek.model.Employee;
import com.iotek.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("adminLogin")
    protected String adminLogin(Employee employee, HttpSession session) throws Exception{
        Employee employee1 = employeeService.adminLogin(employee);
        if (employee1 != null) {
            session.setAttribute("admin",employee1);
            return "forward:getInterview";
        }else {
            return "adminLogin";
        }
    }

    @RequestMapping("adminRegister")
    protected String adminRegister(Employee employee) throws Exception{
        if(employeeService.register(employee)){
            return "adminLogin";
        }else {
            return "adminRegister";
        }
    }

    @RequestMapping("exit")
    protected String exit(HttpSession session) throws Exception{
        session.removeAttribute("admin");
        return "mainForAdmin";
    }
}
