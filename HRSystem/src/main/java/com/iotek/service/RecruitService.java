package com.iotek.service;

import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitService {
    List<Recruit> getAllRecruit();
    Recruit getRecruitById(Integer rct_id);
    List<Recruit> queryAllRecruit();
    boolean deleteRecruit(Recruit recruit);
    boolean updateRecruit(Recruit recruit);
    boolean addRecruit(Recruit recruit);
}
