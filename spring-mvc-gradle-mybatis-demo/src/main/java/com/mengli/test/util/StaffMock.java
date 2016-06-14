package com.mengli.test.util;

import com.mengli.test.dao.StaffDao;
import com.mengli.test.model.Staff;

import javax.annotation.Resource;

/**
 * Created by mlhuang on 4/22/16.
 */
public class StaffMock {
    @Resource
    private StaffDao staffDao;
    public boolean addOne(Staff staff){
        return staffDao.addOne(staff);
    }
}
