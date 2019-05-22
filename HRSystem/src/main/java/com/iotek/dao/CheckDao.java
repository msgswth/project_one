package com.iotek.dao;

import com.iotek.model.Check;

import java.util.List;

public interface CheckDao {
    boolean addCheck(Check check);
    boolean updateCheck(Check check);
    boolean deleteCheck(Check check);
    Check getCheckById(Check check);
    List<Check> getAllCheck();
    List<Check> getCheckByEmpId(Check check);
}
