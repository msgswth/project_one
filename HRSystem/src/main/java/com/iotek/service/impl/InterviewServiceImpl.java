package com.iotek.service.impl;

import com.iotek.dao.InterviewDao;
import com.iotek.model.Interview;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewDao interviewDao;

    public Interview getInterview(Interview interview) {
        if(interview==null){
            return null;
        }
        return interviewDao.getInterview(interview);
    }

    public List<Interview> getInterviewByRsID(Interview interview) {
        if(interview==null){
            return null;
        }
        return interviewDao.getInterviewByRsID(interview);
    }

    public List<Interview> getInterviewByRctID(Interview interview) {
        if(interview==null){
            return null;
        }
        return interviewDao.getInterviewByRctID(interview);
    }

    public boolean addInterview(Interview interview) {
        if(interview==null){
            return false;
        }
        return interviewDao.addInterview(interview);
    }

    public boolean updateInterview(Interview interview) {
        if(interview==null){
            return false;
        }
        return interviewDao.updateInterview(interview);
    }

    public boolean deleteInterview(Interview interview) {
        if(interview==null){
            return false;
        }
        return interviewDao.deleteInterview(interview);
    }
}
