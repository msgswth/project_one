package com.iotek.controller;

import com.iotek.model.Employee;
import com.iotek.model.Train;
import com.iotek.model.TrainEmp;
import com.iotek.model.TrainRecord;
import com.iotek.service.EmployeeService;
import com.iotek.service.TrainRecordService;
import com.iotek.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private TrainRecordService trainRecordService;
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("getTrain")
    protected String getTrain(HttpSession session)throws Exception{
        List<Train> trains=trainService.getAllTrain();
        List<TrainEmp> trainEmps=new ArrayList<TrainEmp>();
        for (Train train : trains) {
            TrainRecord trainRecord=new TrainRecord();
            trainRecord.setTr_id(train.getTr_id());
            List<TrainRecord> trainRecords=trainRecordService.getTDByTrId(trainRecord);
            List<Employee> employees=new ArrayList<Employee>();
            for (TrainRecord record : trainRecords) {
                Integer emp_id=record.getEmp_id();
                Employee employee=employeeService.getEmployeeById(emp_id);
                employees.add(employee);
            }
            TrainEmp trainEmp=new TrainEmp();
            trainEmp.setTrain(train);
            trainEmp.setEmployees(employees);
            trainEmps.add(trainEmp);
        }
        session.setAttribute("trainEmps",trainEmps);
        return "manageTrain";
    }

    @RequestMapping("updateTrain")
    protected String updateTrain(Train train,HttpSession session)throws Exception{
        trainService.updateTrain(train);
        return getTrain(session);
    }

    @RequestMapping("addTrain")
    protected String addTrain(Integer emp_id,Train train,HttpSession session)throws Exception{
        trainService.addTrain(train);
        TrainRecord trainRecord=new TrainRecord();
        trainRecord.setEmp_id(emp_id);
        trainRecord.setTr_id(train.getTr_id());
        trainRecordService.addTD(trainRecord);
        return getTrain(session);
    }

    @RequestMapping("deleteTrain")
    protected String deleteTrain(Train train,HttpSession session)throws Exception{
        if (train.getTr_end_time().getTime()<new Date().getTime()){
            trainService.deleteTrain(train);
        }
        return getTrain(session);
    }
}
