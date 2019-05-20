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
public class DepAndPosController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("showDepAndPos")
    protected String showDepAndPos(HttpSession session)throws Exception{
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
        session.setAttribute("bonds",bonds);
        return "manageDepAndPos";
    }
}
