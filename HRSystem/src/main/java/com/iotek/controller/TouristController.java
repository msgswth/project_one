package com.iotek.controller;

import com.iotek.model.Tourist;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class TouristController {
    @Resource
    private TouristService touristService;

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
}
