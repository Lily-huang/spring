package com.mengli.test.dao;

import com.mengli.test.model.Staff;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by mlhuang on 4/27/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class StaffDaoTest {
    @Resource
    private StaffDao staffDao;
    Staff mockStaff = new Staff("lily", "123", 25);
    Staff insertStaff = new Staff("insert", "333", 12);

    private final Logger logger = LoggerFactory.getLogger(StaffDaoTest.class);

//    @BeforeClass
//    public static void init(){
//        ApplicationContext context=new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/*.xml");
//        staffDao=(StaffDao)context.getBean("staffDao");
//    }

//    @BeforeMethod
//    public void setUp() throws Exception {
//    }


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testGetStaffByNoUseSqlSession() throws Exception {
        assert mockStaff.equals(staffDao.getStaffByNoUseSqlSession(mockStaff.getStaffNo()));
    }

    @Test
    public void testGetStaffByNoUseJDBC() throws Exception {
        assert mockStaff.equals(staffDao.getStaffByNoUseJDBC(mockStaff.getStaffNo()));
    }

    @Test
    public void testAddOne() throws Exception {
        assert true == staffDao.addOne(insertStaff);
    }
}