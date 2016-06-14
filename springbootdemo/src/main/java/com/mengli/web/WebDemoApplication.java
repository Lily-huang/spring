package com.mengli.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mlhuang on 5/13/16.
 */

@SpringBootApplication
@Controller
public class WebDemoApplication implements EmbeddedServletContainerCustomizer{

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    public static void main(String[] args){
        SpringApplication.run(WebDemoApplication.class,args);
    }
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(7000);
    }
}
