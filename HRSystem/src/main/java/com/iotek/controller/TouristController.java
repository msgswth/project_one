package com.iotek.controller;

import com.iotek.model.Interview;
import com.iotek.model.Record;
import com.iotek.model.Recruit;
import com.iotek.model.Tourist;
import com.iotek.service.InterviewService;
import com.iotek.service.RecruitService;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TouristController {
    @Resource
    private TouristService touristService;
    @Resource
    private InterviewService interviewService;
    @Resource
    private RecruitService recruitService;

    @RequestMapping("register")
    protected String register(Tourist tourist) throws Exception{

        if(touristService.register(tourist)){
            return "login";
        }
        return "register";
    }
    @RequestMapping("login")
    protected String login(Tourist tourist, HttpSession session) throws Exception {
        Tourist tourist1 = touristService.login(tourist);
        if (tourist1!=null){
            session.setAttribute("to",tourist1);
            return "main";
        }else {
            return "login";
        }
    }
    @RequestMapping("each")
    protected String each(String method) throws Exception {
        return method;
    }

    @RequestMapping("checkInterview")
    protected String checkInterview(Interview interview,HttpSession session) throws Exception{
        List<Interview> interviews = interviewService.getInterviewByRsID(interview);
        List<Record> records=new ArrayList<Record>();
        for (Interview interview1 : interviews) {
            Record record=new Record();
            Recruit recruit=recruitService.getRecruitById(interview1.getRct_id());
            record.setRecruit(recruit);
            record.setInterview(interview1);
            records.add(record);
        }
        session.setAttribute("checkRecord",records);
        return "checkInterview";
    }

    @RequestMapping("updateInter")
    protected String updateInter(Interview interview) throws Exception{
        interviewService.updateInterview(interview);
        return "main";
    }
}
