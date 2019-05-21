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

    @RequestMapping("showRecruitForAdmin")
    public String showRecruitForAdmin(HttpSession session)throws Exception{
       List<Recruit> recruits=recruitService.queryAllRecruit();
       session.setAttribute("myRecruits",recruits);
       return "manageRecruit";
    }

    @RequestMapping("updateRecruit")
    public String updateRecruit(Recruit rct,HttpSession session)throws Exception{
        recruitService.updateRecruit(rct);
        return showRecruitForAdmin(session);
    }

    @RequestMapping("deleteRecruit")
    public String deleteRecruit(Recruit rct,HttpSession session)throws Exception{
        recruitService.deleteRecruit(rct);
        return showRecruitForAdmin(session);
    }

    @RequestMapping("addRecruit")
    public String addRecruit(Recruit rct,HttpSession session)throws Exception{
        recruitService.addRecruit(rct);
        return showRecruitForAdmin(session);
    }
}
