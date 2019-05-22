package com.iotek.dao;

import com.iotek.model.Reward;

import java.util.List;

public interface RewardDao {
    boolean addReward(Reward reward);
    boolean updateReward(Reward reward);
    boolean deleteReward(Reward reward);
    Reward getRewardById(Reward reward);
    List<Reward> getRewardByEmpId(Reward reward);
}
