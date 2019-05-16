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
}
