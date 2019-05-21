package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.InterviewService;
import com.iotek.service.RecruitService;
import com.iotek.service.ResumeService;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class InterviewController {
    @Resource
    private InterviewService interviewService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private TouristService touristService;
    @Resource
    private RecruitService recruitService;

    @RequestMapping("sendResume")//投递简历
    protected String addInterview(Integer rct_id,Integer t_id) throws Exception{
        Resume resume=new Resume();
        resume.setT_id(t_id);
        Resume re = resumeService.getResume(resume);
        if(re==null){
            return "myResume";
        }else {
            Integer rs_id=re.getRs_id();
            Interview interview=new Interview();
            interview.setRct_id(rct_id);
            interview.setRs_id(rs_id);
            System.out.println(interview);
            interviewService.addInterview(interview);
            return "main";
        }
    }

    @RequestMapping("getInterview")//显示投递的简历
    protected String getInterview(HttpSession session) throws Exception{
        List<Interview> allInterview = interviewService.getAllInterview();
        List<Record> records=new ArrayList<Record>();

        for (Interview interview : allInterview) {
            Record record=new Record();
            Resume resume=new Resume();
            Integer rs_id=interview.getRs_id();
            Integer rct_id=interview.getRct_id();//招聘id
            resume.setRs_id(rs_id);
            Recruit recruit=recruitService.getRecruitById(rct_id);
            Resume resume1 = resumeService.getResumeById(resume);
            Integer t_id=resume1.getT_id();
            Tourist tourist=touristService.getTouristById(t_id);
            record.setTourist(tourist);
            record.setInterview(interview);
            record.setRecruit(recruit);
            records.add(record);
        }
        session.setAttribute("allInterview",records);
        return "mainForAdmin";
    }

    @RequestMapping("updateInterview")
    protected String updateInterview(Interview interview,HttpSession session) throws Exception{
        interviewService.updateInterview(interview);
        return getInterview(session);
    }


}
