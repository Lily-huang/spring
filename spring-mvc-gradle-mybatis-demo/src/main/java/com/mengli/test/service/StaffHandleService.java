package com.mengli.test.service;

import com.mengli.test.dao.StaffDao;
import com.mengli.test.model.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mlhuang on 4/21/16.
 */

@Service
public class StaffHandleService {
    private final Logger logger = LoggerFactory.getLogger(StaffHandleService.class);

    @Resource
    StaffDao staffDao;

    public Staff getStaffInfoUseSqlSession(String staffNo) {
        logger.debug("get service" + staffNo);
        return staffDao.getStaffByNoUseSqlSession(staffNo);
    }

    public Staff getStaffInfoUseJDBC(String staffNo) {
        logger.debug("get service" + staffNo);
        return staffDao.getStaffByNoUseJDBC(staffNo);
    }

    public boolean insertStaff(Staff staff) {
        return staffDao.addOne(staff);
    }
}
