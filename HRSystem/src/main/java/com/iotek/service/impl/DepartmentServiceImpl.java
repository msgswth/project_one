package com.iotek.service.impl;

import com.iotek.dao.DepartmentDao;
import com.iotek.dao.EmployeeDao;
import com.iotek.dao.PositionDao;
import com.iotek.model.Department;
import com.iotek.model.Position;
import com.iotek.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private PositionDao positionDao;
    @Resource
    private EmployeeDao employeeDao;

    public boolean addDepartment(Department department) {
        List<Department> departments=departmentDao.getAllDepartment();
        if(department==null){
            return false;
        }else {
            if(departments!=null &&departments.size()!=0){
                for (Department department1 : departments) {
                    if(department.getDep_name().equals(department1.getDep_name())){
                        return false;
                    }
                }
            }
        }
        return departmentDao.addDepartment(department);
    }

    public boolean deleteDepartment(Department department) {
        List<Position> positions = positionDao.getPositionByDepId(department.getDep_id());
        if(department==null || positions==null || positions.size()==0) {
            return false;
        }else {
            for (Position position : positions) {
                if(employeeDao.getEmployeeByPosId(position.getPos_id())!=null){
                    return false;
                }
            }
            for (Position position : positions) {
                positionDao.deletePosition(position);
            }
            return departmentDao.deleteDepartment(department);
        }
    }

    public boolean updateDepartment(Department department) {
        if (department==null){
            return false;
        }
        return departmentDao.updateDepartment(department);
    }

    public Department getDepById(Department department) {
        if(department==null){
            return null;
        }
        return departmentDao.getDepById(department);
    }

    public Department getDepByName(Department department) {
        if(department==null){
            return null;
        }
        return departmentDao.getDepByName(department);
    }

    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }
}
