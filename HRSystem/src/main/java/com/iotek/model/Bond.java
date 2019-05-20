package com.iotek.model;

import java.io.Serializable;

public class Bond implements Serializable {
    private Department department;
    private Position position;
    private Employee employee;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "department=" + department +
                ", position=" + position +
                ", employee=" + employee +
                '}';
    }
}
