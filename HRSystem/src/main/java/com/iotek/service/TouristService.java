package com.iotek.service;

import com.iotek.model.Tourist;

import java.util.List;

public interface TouristService {
    Tourist login(Tourist tourist);
    boolean register(Tourist tourist);
    List<Tourist> getAllTourist();
}
