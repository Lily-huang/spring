package com.mengli.test.controller;

import com.mengli.test.model.Staff;
import com.mengli.test.service.StaffHandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by mlhuang on 5/4/16.
 */
@Controller
@RequestMapping(value = "/staff")
public class StaffController {
    private final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Resource
    private StaffHandleService staffHandleService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView staff() {
        return new ModelAndView("addStaff", "command", new Staff());
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String addStaff(@ModelAttribute("SpringWeb") Staff staff,
                           ModelMap model) {
        model.addAttribute("name", staff.getName());
        model.addAttribute("age", staff.getAge());
        model.addAttribute("staffNo", staff.getStaffNo());
        logger.debug("staff info" + staff.toString());
        if (staffHandleService.insertStaff(staff))
            return "staffInfo";
        model.addAttribute("msg", "粗问题啦,重新试试吧");
        return "ops";
    }
}
