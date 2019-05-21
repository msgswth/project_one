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
import org.springframework.web.bind.annotation.ResponseBody;

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
        session.setAttribute("departments",departments);
        return "manageDepAndPos";
    }

    @RequestMapping("updateDepAndPos")
    protected String updateDepAndPos(Department department,Position position,HttpSession session)throws Exception{
        departmentService.updateDepartment(department);
        positionService.updatePosition(position);
        return showDepAndPos(session);
    }

    @RequestMapping("deleteDepAndPos")
    protected String deleteDepAndPos(Department department,Position position,HttpSession session)throws Exception{
        positionService.deletePosition(position);
        departmentService.deleteDepartment(department);
        return showDepAndPos(session);
    }

    @RequestMapping("addDepAndPos")
    protected String addDepAndPos(Department department,String pos_name,HttpSession session)throws Exception{
        departmentService.addDepartment(department);
        Department department1=departmentService.getDepByName(department);
        Position position=new Position();
        position.setPos_name(pos_name);
        position.setDep_id(department1.getDep_id());
        positionService.addPosition(position);
        return showDepAndPos(session);
    }

    @RequestMapping("findDep")
    @ResponseBody
    protected List<Department> findDep(HttpSession session)throws Exception{
        List<Department> departments=departmentService.getAllDepartment();
        return departments;
    }

    @RequestMapping("findPos")
    @ResponseBody
    protected List<Position> findPos(Integer dep_id,HttpSession session)throws Exception{
        List<Position> positions=positionService.getPositionByDepId(dep_id);
        return positions;
    }

    @RequestMapping("findEmp")
    @ResponseBody
    protected Employee findEmp(Integer pos_id,HttpSession session)throws Exception{
        Employee employee=employeeService.getEmployeeByPosId(pos_id);
        return employee;
    }
}
