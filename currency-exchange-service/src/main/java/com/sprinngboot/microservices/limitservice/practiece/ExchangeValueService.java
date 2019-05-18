package com.sprinngboot.microservices.limitservice.practiece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinngboot.microservices.limitservice.practiece.bean.ExchangeValue;

@Service
public class ExchangeValueService {

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	public ExchangeValue findExchangeValueByFromAndTO(String from, String to){
		return exchangeValueRepository.findByFromAndTo(from, to);
	}
}
