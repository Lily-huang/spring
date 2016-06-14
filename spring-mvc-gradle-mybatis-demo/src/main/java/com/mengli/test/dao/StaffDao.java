package com.mengli.test.dao;

import com.mengli.test.mapper.StaffMapper;
import com.mengli.test.model.Staff;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlhuang on 4/21/16.
 */
@Repository
public class StaffDao implements IStaffDao {
    private final Logger logger = LoggerFactory.getLogger(StaffDao.class);

    @Resource
    public SqlSessionTemplate sqlSession;

    @Resource
    public JdbcTemplate jdbcTemplate;

    @Override
    public Staff getStaffByNoUseSqlSession(String No) {
        logger.debug("get dao " + No);
        try {
            return sqlSession.selectOne("domain.Staff.getStaffByNo", No);
        } catch (Exception e) {
            logger.debug("error ----------------------", e);
        }
        return new Staff("lily", "mock test", 25);
    }

    @Override
    public Staff getStaffByNoUseJDBC(String No) {
        logger.debug("get dao " + No);
        String sql = "select staff_name,staff_no,age from test.staff where staff_no =" + No;
        logger.debug("sql is " + sql);
        List list = new ArrayList();
        try {
            list = jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            logger.debug("exp is ", e);
        }
        if (list.size() == 0) {
            logger.debug("get null set");
            return new Staff("lily", "mock test", 25);
        }
        return StaffMapper.getStaffList(list).get(0);
    }

    @Override
    public boolean addOne(Staff staff) {
        return sqlSession.insert("domain.Staff.insert", staff) == 0 ? false : true;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
