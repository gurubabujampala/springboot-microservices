/**
 * 
 */
package com.sprinngboot.microservices.limitservice.practiece;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprinngboot.microservices.limitservice.practiece.bean.CurerencyConversionBean;

/**
 * @author jampala
 *
 */
//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface ExchangeCurrencyServiceProxy {

//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurerencyConversionBean fetchExchangeValue(
			@PathVariable("from") String from, 
			@PathVariable("to") String to);
}
