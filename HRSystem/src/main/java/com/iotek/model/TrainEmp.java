package com.iotek.model;

import java.io.Serializable;
import java.util.List;

public class TrainEmp implements Serializable {
    private Train train;
    private List<Employee> employees;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "TrainEmp{" +
                "train=" + train +
                ", employees=" + employees +
                '}';
    }
}
