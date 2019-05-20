package com.iotek.service.impl;

import com.iotek.dao.EmployeeDao;
import com.iotek.dao.PositionDao;
import com.iotek.model.Employee;
import com.iotek.model.Position;
import com.iotek.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service

public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;
    @Resource
    private EmployeeDao employeeDao;

    public boolean addPosition(Position position) {
        List<Position> positions=positionDao.getAllPosition();
        if(position==null){
            return false;
        }else {
            if(positions!=null && positions.size()!=0){
                for (Position position1 : positions) {
                    if(position.getPos_name().equals(position1.getPos_name())){
                        return false;
                    }
                }
            }
        }
        return positionDao.addPosition(position);
    }

    public boolean updatePosition(Position position) {
        if(position==null){
            return false;
        }
        return positionDao.updatePosition(position);
    }

    public boolean deletePosition(Position position) {
        if(position==null){
            return false;
        }else if(employeeDao.getEmployeeByPosId(position.getPos_id())!=null){
            return false;
        }else {
            return positionDao.deletePosition(position);
        }
    }

    public List<Position> getPositionByDepId(Integer dep_id) {
        if(dep_id==null || dep_id==0){
            return null;
        }
        return positionDao.getPositionByDepId(dep_id);
    }

    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    public Position getPositionById(Integer pos_id) {
        if(pos_id==null || pos_id==0){
            return null;
        }
        return positionDao.getPositionById(pos_id);
    }
}
