package com.iotek.controller;

import com.iotek.model.Resume;
import com.iotek.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @RequestMapping("getResume")
    protected String getResume(Resume re,HttpSession session) throws Exception {
        Resume resume=resumeService.getResume(re);
        session.setAttribute("myResume",resume);
        return "myResume";
    }

    @RequestMapping("deleteResume")
    protected String deleteResume(Resume re,HttpSession session) throws Exception {
        resumeService.deleteResume(re);
        return getResume(re, session);
    }

    @RequestMapping("updateResume")
    protected String updateResume(Resume re,HttpSession session) throws Exception {
        resumeService.updateResume(re);
        return getResume(re, session);
    }

    @RequestMapping("addResume")
    protected String addResume(Resume re,HttpSession session) throws Exception {
        resumeService.addResume(re);
        return getResume(re, session);
    }
}
