package com.mengli.test.controller;

import com.mengli.test.model.Staff;
import com.mengli.test.service.StaffHandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by mlhuang on 4/22/16.
 */

@Controller
@RequestMapping(value = "/test")
@ResponseBody
@EnableWebMvc
public class StaffSqlSessionController {
    private final Logger logger = LoggerFactory.getLogger(StaffSqlSessionController.class);

    @Resource
    private StaffHandleService staffHandleService;

    @RequestMapping(value = "query/{no:.+}", method = RequestMethod.GET)
    public ModelAndView getStaff(@PathVariable("no") String no) {
        logger.debug("getStaff method call");
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.setViewName("test");
        modelAndView.addObject("testMsg", "modelAndView test");
        logger.debug("no is " + no);
        Staff staff = staffHandleService.getStaffInfoUseSqlSession(no);
        logger.debug(staff.toString());
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }

    @RequestMapping(value = "json/{no}", method = RequestMethod.GET)
    @ResponseBody
    public Staff getStaffInfo(@PathVariable("no") String no) {
        logger.debug("get json");
        Staff staff = staffHandleService.getStaffInfoUseSqlSession(no);
        return staff;
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String insertStaff(Map<String, Object> model) {
        logger.debug("step into insert");
        model.put("result", staffHandleService.insertStaff(new Staff("insertTest", "333", 20)));
        return "test";
    }
}
