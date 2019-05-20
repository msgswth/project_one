package com.iotek.service;

import com.iotek.model.Department;

import java.util.List;

public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean deleteDepartment(Department department);
    boolean updateDepartment(Department department);
    Department getDepById(Department department);
    List<Department> getAllDepartment();
}
