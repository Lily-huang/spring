package com.mengli.server.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mlhuang on 5/16/16.
 */
@Component
public class ApiData extends DataAdapter {
    private RestTemplate restTemplate=new RestTemplate();

    @Override
    public JsonNode getData(String no){
        dataProvider.init();
        JsonNode jsonNode=restTemplate.getForObject(dataProvider.getApi()+no,JsonNode.class);
        return jsonNode;
    }
}
