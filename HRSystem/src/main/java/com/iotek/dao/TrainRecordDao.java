package com.iotek.dao;

import com.iotek.model.TrainRecord;

import java.util.List;

public interface TrainRecordDao {
    boolean addTD(TrainRecord trainRecord);
    boolean updateTD(TrainRecord trainRecord);
    boolean deleteTD(TrainRecord trainRecord);
    List<TrainRecord> getTDByEmpId(TrainRecord trainRecord);
    List<TrainRecord> getTDByTrId(TrainRecord trainRecord);
}
