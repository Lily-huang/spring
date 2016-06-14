package com.mengli.server.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by mlhuang on 5/16/16.
 */
@Component
public class DataProvider {
    @Autowired
    private Environment environment;
    private String api;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
    public void init(){
        setApi(environment.getProperty("data.api"));
    }
}
