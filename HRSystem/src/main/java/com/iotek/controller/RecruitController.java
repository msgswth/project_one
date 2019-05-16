package com.iotek.controller;

import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;

    @RequestMapping("/")
    public String first()throws Exception{
        return "forward:showRecruit";
    }

    @RequestMapping("showRecruit")
    public String showRecruit(HttpSession session)throws Exception{
        List<Recruit> recruits=recruitService.getAllRecruit();
        session.setAttribute("recruits",recruits);
        return "../../index";
    }

    @RequestMapping("showInMain")
    public String showInMain(HttpSession session)throws Exception{
        List<Recruit> recruits=recruitService.getAllRecruit();
        session.setAttribute("recruits",recruits);
        return "main";
    }
}
