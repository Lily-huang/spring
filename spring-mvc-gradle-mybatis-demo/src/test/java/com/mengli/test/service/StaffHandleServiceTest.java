package com.mengli.test.service;

import com.mengli.test.model.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by mlhuang on 5/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class StaffHandleServiceTest {
    @Resource
    private StaffHandleService staffHandleService;
    Staff mockStaff = new Staff("lily", "123", 25);
    Staff insertStaff = new Staff("insert", "333", 12);

    @Test
    public void testGetStaffInfoUseSqlSession() throws Exception {
        assert mockStaff.equals(staffHandleService.getStaffInfoUseSqlSession(mockStaff.getStaffNo()));

    }

    @Test
    public void testGetStaffInfoUseJDBC() throws Exception {
        assert mockStaff.equals(staffHandleService.getStaffInfoUseJDBC(mockStaff.getStaffNo()));
    }

    @Test
    public void testInsertStaff() throws Exception {
        assert true == staffHandleService.insertStaff(insertStaff);
    }

}