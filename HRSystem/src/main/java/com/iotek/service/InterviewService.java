package com.iotek.service;

import com.iotek.model.Interview;

import java.util.List;

public interface InterviewService {
    Interview getInterview(Interview interview);//通过简历id和招聘id查询面试信息
    List<Interview> getInterviewByRsID(Interview interview);//通过简历id查询
    List<Interview> getInterviewByRctID(Interview interview);//通过招聘id查询
    boolean addInterview(Interview interview);
    boolean updateInterview(Interview interview);
    boolean deleteInterview(Interview interview);
}
