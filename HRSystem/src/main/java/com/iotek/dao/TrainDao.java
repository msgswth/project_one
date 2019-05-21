package com.iotek.dao;

import com.iotek.model.Train;

import java.util.List;

public interface TrainDao {
    List<Train> getAllTrain();
    List<Train> getTrainByState(Train train);
    boolean updateTrain(Train train);
    boolean deleteTrain(Train train);
    boolean addTrain(Train train);
}
