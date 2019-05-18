package com.sprinngboot.microservices.limitservice.practiece;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sprinngboot.microservices.limitservice.practiece.bean.CurerencyConversionBean;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ExchangeCurrencyServiceProxy proxy;
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurerencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		
		Map<String, String> uriValues = new HashMap<>();
		uriValues.put("from", from);
		uriValues.put("to", to);
		
		ResponseEntity<CurerencyConversionBean> responseEntity = restTemplate.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurerencyConversionBean.class, uriValues);
		
		CurerencyConversionBean response = responseEntity.getBody();		
		
		return new CurerencyConversionBean(
				response.getId(),
				from,
				to,
				response.getConversionMultiple(),
				quantity,
				response.getConversionMultiple().multiply(quantity),
				response.getPort());
		
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurerencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		CurerencyConversionBean response = proxy.fetchExchangeValue(from, to);
		
		logger.info("{} -> "+response);
		
		return new CurerencyConversionBean(
				response.getId(), from, to, response.getConversionMultiple(), quantity,
				response.getConversionMultiple().multiply(quantity), response.getPort());
		
	}
}
