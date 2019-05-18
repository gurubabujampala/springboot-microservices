package com.sprinngboot.microservices.limitservice.practiece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinngboot.microservices.limitservice.practiece.bean.LimitsConfiguration;

@RestController
public class LimitsConfigController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitsConfiguration fetchLimitsConfiguration(){
		return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	
}
