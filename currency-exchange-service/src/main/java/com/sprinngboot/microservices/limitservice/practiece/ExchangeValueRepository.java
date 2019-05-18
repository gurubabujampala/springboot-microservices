/**
 * 
 */
package com.sprinngboot.microservices.limitservice.practiece;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinngboot.microservices.limitservice.practiece.bean.ExchangeValue;

/**
 * @author jampala
 *
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
