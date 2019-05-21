package com.iotek.service.impl;

import com.iotek.dao.TrainRecordDao;
import com.iotek.model.TrainRecord;
import com.iotek.service.TrainRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrainRecordServiceImpl implements TrainRecordService {
    @Resource
    private TrainRecordDao trainRecordDao;

    public boolean addTD(TrainRecord trainRecord) {
        if(trainRecord==null){
            return false;
        }
        return trainRecordDao.addTD(trainRecord);
    }

    public boolean updateTD(TrainRecord trainRecord) {
        if(trainRecord==null){
            return false;
        }
        return trainRecordDao.updateTD(trainRecord);
    }

    public boolean deleteTD(TrainRecord trainRecord) {
        if(trainRecord==null){
            return false;
        }
        return trainRecordDao.deleteTD(trainRecord);
    }

    public List<TrainRecord> getTDByEmpId(TrainRecord trainRecord) {
        if(trainRecord==null){
            return null;
        }
        return trainRecordDao.getTDByEmpId(trainRecord);
    }

    public List<TrainRecord> getTDByTrId(TrainRecord trainRecord) {
        if(trainRecord==null){
            return null;
        }
        return trainRecordDao.getTDByTrId(trainRecord);
    }
}
