package com.iotek.service.impl;

import com.iotek.dao.RewardDao;
import com.iotek.model.Reward;
import com.iotek.service.RewardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RewardServiceImpl implements RewardService {
    @Resource
    private RewardDao rewardDao;

    public boolean addReward(Reward reward) {
        if (reward == null) {
            return false;
        }
        return rewardDao.addReward(reward);
    }

    public boolean updateReward(Reward reward) {
        if(reward==null){
            return false;
        }
        return rewardDao.updateReward(reward);
    }

    public boolean deleteReward(Reward reward) {
        if(reward==null){
            return false;
        }
        return rewardDao.deleteReward(reward);
    }

    public Reward getRewardById(Reward reward) {
        if(reward==null){
            return null;
        }
        return rewardDao.getRewardById(reward);
    }

    public List<Reward> getRewardByEmpId(Reward reward) {
        if(reward==null){
            return null;
        }
        return rewardDao.getRewardByEmpId(reward);
    }
}
