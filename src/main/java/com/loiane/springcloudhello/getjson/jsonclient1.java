package com.loiane.springcloudhello.getjson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
public class jsonclient1 {
	
	
	public void jsonclient1gettestjson() {
	
	  Logger log = LoggerFactory.getLogger(jsonclient1.class);
	        RestTemplate restTemplate = new RestTemplate();
	        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	        log.info(quote.toString());
	    
	}
}
