package com.mengli.test.controller;

import com.mengli.test.service.StaffHandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by mlhuang on 5/3/16.
 */

@Controller
@RequestMapping(value = "/")
public class StaffJDBCController {
    private final Logger logger = LoggerFactory.getLogger(StaffJDBCController.class);

    @Resource
    private StaffHandleService staffHandleService;

    @RequestMapping(value = "js", method = RequestMethod.GET)
    public String index(Map<String, Object> map, HttpServletRequest req) {
        logger.debug("step into index");
        map.put("name", req.getParameter("name"));
        map.put("note", req.getParameter("note"));
        return "jsTest";
    }

    @RequestMapping(value = "jdbc/do", method = RequestMethod.GET)
    public String learn(Map<String, Object> model) {
        logger.debug("learn method call");
        model.put("testMsg", "hello lily");
        model.put("staff", staffHandleService.getStaffInfoUseJDBC("123").toString());
        return "learn";
    }
}
