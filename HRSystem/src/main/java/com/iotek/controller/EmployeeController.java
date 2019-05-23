package com.iotek.controller;

import com.iotek.model.Bond;
import com.iotek.model.Department;
import com.iotek.model.Employee;
import com.iotek.model.Position;
import com.iotek.service.DepartmentService;
import com.iotek.service.EmployeeService;
import com.iotek.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    @RequestMapping("adminLogin")
    protected String adminLogin(Employee employee, HttpSession session) throws Exception{
        Employee employee1 = employeeService.adminLogin(employee);
//        List<Employee> emps=employeeService.getAllEmployee();
//        session.setAttribute("emps",emps);
        if (employee1 != null) {
            session.setAttribute("admin",employee1);
            return "forward:getInterview";
        }else {
            return "adminLogin";
        }
    }

    @RequestMapping("empLogin")
    protected String empLogin(Employee employee, HttpSession session) throws Exception{
        Employee employee1 = employeeService.login(employee);
        if (employee1 != null) {
            session.setAttribute("employee",employee1);
            return "mainForEmp";
        }else {
            return "empLogin";
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

    @RequestMapping("getMessage")
    protected String getMessage(HttpSession session) throws Exception{
        List<Department> departments=departmentService.getAllDepartment();
        List<Bond> bonds=new ArrayList<Bond>();
        if(departments!=null&&departments.size()!=0){
            for (Department department : departments) {
                List<Position> positions=positionService.getPositionByDepId(department.getDep_id());
                if(positions!=null&&positions.size()!=0){
                    for (Position position : positions) {
                        Employee employee=employeeService.getEmployeeByPosId(position.getPos_id());
                        Bond bond=new Bond();
                        bond.setPosition(position);
                        bond.setDepartment(department);
                        bond.setEmployee(employee);
                        bonds.add(bond);
                    }
                }
            }
        }
        session.setAttribute("messages",bonds);
        return "getMessage";
    }
}
