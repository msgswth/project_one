package com.iotek.service.impl;

import com.iotek.dao.ResumeDao;
import com.iotek.model.Resume;
import com.iotek.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeDao resumeDao;

    public Resume getResume(Resume resume) {
        if(resume==null){
            return null;
        }
        return resumeDao.getResume(resume);
    }

    public boolean addResume(Resume resume) {
        if(resume==null){
            return false;
        }
        return resumeDao.addResume(resume);
    }

    public boolean updateResume(Resume resume) {
        if(resume==null){
            return false;
        }
        return resumeDao.updateResume(resume);
    }

    public boolean deleteResume(Resume resume) {
        if(resume==null){
            return false;
        }
        return resumeDao.deleteResume(resume);
    }
}
