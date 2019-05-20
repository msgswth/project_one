package com.iotek.controller;

import com.iotek.model.Resume;
import com.iotek.model.Tourist;
import com.iotek.service.ResumeService;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;
    @Resource
    private TouristService touristService;

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

    @RequestMapping("getResumeForAdmin")
    protected String getResumeForAdmin(Integer t_id, Resume re, HttpSession session) throws Exception {
        Resume resume=resumeService.getResumeById(re);
        session.setAttribute("resumeForAdmin",resume);
        Tourist tourist=touristService.getTouristById(t_id);
        session.setAttribute("t",tourist);
        return "showResumeForAdmin";
    }
}
