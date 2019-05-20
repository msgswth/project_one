package com.iotek.dao;

import com.iotek.model.Position;

import java.util.List;

public interface PositionDao {
    boolean addPosition(Position position);
    boolean updatePosition(Position position);
    boolean deletePosition(Position position);
    List<Position> getPositionByDepId(Integer dep_id);
    List<Position> getAllPosition();
    Position getPositionById(Integer pos_id);
}
