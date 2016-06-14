package com.mengli.server.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.mengli.server.model.Staff;

/**
 * Created by mlhuang on 5/17/16.
 */
public class DataTransform {
    public static Staff staffTransform(JsonNode jsonNode){
        Staff staff=new Staff();
        staff.setStaffNo(jsonNode.get("staffNo").asText());
        staff.setName(jsonNode.get("name").asText());
        staff.setAge((Integer.parseInt(jsonNode.get("age").toString())));
        return staff;
    }
}
