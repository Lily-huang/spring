package com.mengli.server.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.mengli.server.data.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mlhuang on 5/16/16.
 */
public class DataAdapter{
    @Autowired
    protected DataProvider dataProvider;

    public JsonNode getData(String no){
        return null;
    }
}
