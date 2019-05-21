package com.iotek.service.impl;

import com.iotek.dao.TrainDao;
import com.iotek.model.Train;
import com.iotek.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainDao trainDao;

    public List<Train> getAllTrain() {
        return trainDao.getAllTrain();
    }

    public List<Train> getTrainByState(Train train) {
        if(train==null){
            return null;
        }
        return trainDao.getTrainByState(train);
    }

    public boolean updateTrain(Train train) {
        if(train==null){
            return false;
        }else if(!train.getTr_is_publish().equals("未发布")){
            return false;
        }
        return trainDao.updateTrain(train);
    }

    public boolean deleteTrain(Train train) {
        if(train==null){
            return false;
        }else if(train.getTr_is_publish().equals("已发布")){
            return false;
        }else {
            return trainDao.deleteTrain(train);
        }
    }

    public boolean addTrain(Train train) {
        if(train==null){
            return false;
        }
        return trainDao.addTrain(train);
    }
}
