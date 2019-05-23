package com.iotek.service;

import com.iotek.model.Reward;

import java.util.List;

public interface RewardService {
    boolean addReward(Reward reward);
    boolean updateReward(Reward reward);
    boolean deleteReward(Reward reward);
    Reward getRewardById(Reward reward);
    List<Reward> getRewardByEmpId(Reward reward);
}
