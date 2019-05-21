package com.iotek.service;

import com.iotek.model.TrainRecord;

import java.util.List;

public interface TrainRecordService {
    boolean addTD(TrainRecord trainRecord);
    boolean updateTD(TrainRecord trainRecord);
    boolean deleteTD(TrainRecord trainRecord);
    List<TrainRecord> getTDByEmpId(TrainRecord trainRecord);
    List<TrainRecord> getTDByTrId(TrainRecord trainRecord);
}
