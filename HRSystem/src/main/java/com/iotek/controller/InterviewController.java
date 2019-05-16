package com.iotek.controller;

import com.iotek.service.InterviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class InterviewController {
    @Resource
    private InterviewService interviewService;

    @RequestMapping("sendResume")//投递简历
    protected String addInterview() throws Exception{


        return "main";
    }


}
