package com.mengli.server;

import com.mengli.server.adapter.ApiData;
import com.mengli.server.adapter.DataTransform;
import com.mengli.server.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:7000", maxAge = 3600)
@SpringBootApplication
@RestController
public class DemoApplication implements EmbeddedServletContainerCustomizer {

	@Autowired
	private ApiData apiData;

	@RequestMapping(value = "query/{staffNo}",method = RequestMethod.GET)
	@ResponseBody
	public Staff query(@PathVariable("staffNo") String staffNo){
		System.out.println("*****"+staffNo);
		return DataTransform.staffTransform(apiData.getData(staffNo));
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {

	}
}
