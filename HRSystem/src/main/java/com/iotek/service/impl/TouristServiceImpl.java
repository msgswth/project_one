package com.iotek.service.impl;

import com.iotek.dao.TouristDao;
import com.iotek.model.Tourist;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TouristServiceImpl implements TouristService {
    @Resource
    private TouristDao touristDao;
    public Tourist login(Tourist tourist) {
        if(tourist==null){
            return null;
        }
        return touristDao.getTourist(tourist);
    }

    public boolean register(Tourist tourist) {
        if(tourist==null){
            return false;
        }
        return touristDao.addTourist(tourist);
    }

    public List<Tourist> getAllTourist() {
        return touristDao.getAllTourist();
    }

    public Tourist getTouristById(Integer t_id) {
        if(t_id==null||t_id==0){
            return null;
        }
        return touristDao.getTouristById(t_id);
    }
}
