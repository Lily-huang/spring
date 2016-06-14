package com.mengli.test.mapper;

import com.mengli.test.model.Staff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by mlhuang on 4/26/16.
 */
public class StaffMapper {
    public static List<Staff> getStaffList(List list) {
        List<Staff> staffs = new ArrayList<Staff>();
        Iterator iterator = list.iterator();
        Staff staff = null;
        while (iterator.hasNext()) {
            Map map4dept = (Map) iterator.next();
            staff = new Staff();
            staff.setName((String) map4dept.get("staff_name"));
            staff.setStaffNo((String) map4dept.get("staff_no"));
            staff.setAge((Integer) map4dept.get("age"));
            staffs.add(staff);
        }
        return staffs;
    }
}
