package com.mengli.test.dao;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by mlhuang on 5/17/16.
 */
public class StaffDaoUnitTest {

    public static final String NO = "123";
    public static final String sql="";
    private final StaffDao staffDao = new StaffDao();
    private final SqlSessionTemplate mockSqlSession = EasyMock.mock(SqlSessionTemplate.class);
    private final JdbcTemplate mockJdbcTemplate=EasyMock.mock(JdbcTemplate.class);

    @Before
    public void setUp() throws Exception {
        staffDao.setSqlSession(mockSqlSession);
        staffDao.setJdbcTemplate(mockJdbcTemplate);
    }

    @Test
    public void shouldGetStaffByNoUseSqlSession() throws Exception {
        EasyMock.expect(mockSqlSession.selectOne("domain.Staff.getStaffByNo", NO));

        EasyMock.replay();
        staffDao.getStaffByNoUseSqlSession(NO);
        EasyMock.verify();
    }

    @Test
    public void shouldGetStaffByNoUseJDBC() throws Exception{
//        Mockito.when(mockJdbcTemplate.queryForList(sql)).thenReturn(staffDao.getStaffByNoUseJDBC(NO));

        EasyMock.expect(mockJdbcTemplate.queryForList(sql));

        EasyMock.replay();
        staffDao.getStaffByNoUseJDBC(NO);
        EasyMock.verify();
    }
}