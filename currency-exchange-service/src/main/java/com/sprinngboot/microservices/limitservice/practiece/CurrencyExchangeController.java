package com.sprinngboot.microservices.limitservice.practiece;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sprinngboot.microservices.limitservice.practiece.bean.ExchangeValue;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueService exchangeValueService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue fetchExchangeValue(@PathVariable String from, @PathVariable String to){
		ExchangeValue exchangeCurrency = exchangeValueService.findExchangeValueByFromAndTO(from, to);
		
		logger.info("{} -> "+exchangeCurrency);
		
		exchangeCurrency.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeCurrency;
	}
	
}
