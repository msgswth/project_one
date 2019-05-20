package com.iotek.dao;

import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitDao {
    List<Recruit> getAllRecruit();//获取所有已发布的招聘信息
    Recruit getRecruitById(Integer rct_id);
    List<Recruit> queryAllRecruit();//获取所有的招聘信息
    boolean deleteRecruit(Integer rct_id);
    boolean updateRecruit(Recruit recruit);
    boolean addRecruit(Recruit recruit);
}
