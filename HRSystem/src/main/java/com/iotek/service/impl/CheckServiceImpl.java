package com.iotek.service.impl;

import com.iotek.dao.CheckDao;
import com.iotek.model.Check;
import com.iotek.service.CheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CheckServiceImpl implements CheckService {
    @Resource
    private CheckDao checkDao;

    public boolean addCheck(Check check) {
        if(check==null){
            return false;
        }
        return checkDao.addCheck(check);
    }

    public boolean updateCheck(Check check) {
        if(check==null){
            return false;
        }
        return checkDao.updateCheck(check);
    }

    public boolean deleteCheck(Check check) {
        if(check==null){
            return false;
        }
        return checkDao.deleteCheck(check);
    }

    public Check getCheckById(Check check) {
        if(check==null){
            return null;
        }
        return checkDao.getCheckById(check);
    }

    public List<Check> getAllCheck() {
        return checkDao.getAllCheck();
    }

    public List<Check> getCheckByEmpId(Check check) {
        if(check==null){
            return null;
        }
        return checkDao.getCheckByEmpId(check);
    }

}
