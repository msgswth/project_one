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
import java.text.SimpleDateFormat;
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
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");

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
    protected String addTrain(String time1,String time2,Train train,HttpSession session)throws Exception{
        java.sql.Date d1=train.getTr_start_time();
        java.sql.Date d2=train.getTr_end_time();
        String date1=sdf.format(d1)+"-"+time1;
        String date2=sdf.format(d2)+"-"+time2;
        train.setTr_start_time(new java.sql.Date(simpleDateFormat.parse(date1).getTime()));
        train.setTr_end_time(new java.sql.Date(simpleDateFormat.parse(date2).getTime()));
        trainService.addTrain(train);
        System.out.println(date1);
        return getTrain(session);
    }

    @RequestMapping("deleteTrain")
    protected String deleteTrain(Train train,HttpSession session)throws Exception{
        if (train.getTr_end_time().getTime()<new Date().getTime()){
            trainService.deleteTrain(train);
        }
        return getTrain(session);
    }

    @RequestMapping("addTrainRecord")
    protected String addTrainRecord(Integer tr_id,Integer[] emp_id,HttpSession session)throws Exception{
        TrainRecord trainRecord=new TrainRecord();
        for (Integer emp : emp_id) {
            trainRecord.setTr_id(tr_id);
            trainRecord.setEmp_id(emp);
            trainRecordService.addTD(trainRecord);
        }
        return getTrain(session);
    }
}
