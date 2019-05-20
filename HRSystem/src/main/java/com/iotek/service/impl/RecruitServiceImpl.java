package com.iotek.service.impl;

import com.iotek.dao.RecruitDao;
import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;
    public List<Recruit> getAllRecruit() {
        return recruitDao.getAllRecruit();
    }

    public Recruit getRecruitById(Integer rct_id) {
        if(rct_id==null || rct_id==0){
            return null;
        }
        return recruitDao.getRecruitById(rct_id);
    }

    public List<Recruit> queryAllRecruit() {
        return recruitDao.queryAllRecruit();
    }

    public boolean deleteRecruit(Integer rct_id) {
        if(rct_id==null || rct_id==0){
            return false;
        }
        return recruitDao.deleteRecruit(rct_id);
    }

    public boolean updateRecruit(Recruit recruit) {
        if(recruit==null){
            return false;
        }
        return recruitDao.updateRecruit(recruit);
    }

    public boolean addRecruit(Recruit recruit) {
        if(recruit==null){
            return false;
        }
        return recruitDao.addRecruit(recruit);
    }
}
