package com.iotek.dao;

import com.iotek.model.Tourist;

import java.util.List;

public interface TouristDao {
    Tourist getTourist(Tourist tourist);
    boolean addTourist(Tourist tourist);
    List<Tourist> getAllTourist();
}
