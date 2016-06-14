package com.mengli.test.dao;

import com.mengli.test.model.Staff;

/**
 * Created by mlhuang on 4/25/16.
 */

public interface IStaffDao {
    Staff getStaffByNoUseSqlSession(String No);

    Staff getStaffByNoUseJDBC(String No);

    boolean addOne(Staff staff);
}
