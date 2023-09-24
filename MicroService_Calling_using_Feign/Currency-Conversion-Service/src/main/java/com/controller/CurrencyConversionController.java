package com.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import com.proxy.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entity.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	//  Using RestTemplate:
	//  localhost:8100/currency-conversion-rest/from/{from}/to/{to}/quantity/{quantity}
	
	@GetMapping("/currency-conversion-rest/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
														  @PathVariable String to,
														  @PathVariable BigDecimal quantity) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity
		("http://localhost:8000/currency-exchange-value/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		return new CurrencyConversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment()+ " " + "Rest-Template");
	}
	
	/*
	 * 	Response: 
	 * 
	    {
		    "id": 2,
		    "from": "USD",
		    "to": "INR",
		    "quantity": 10,
		    "conversionMultiple": 65.00,
		    "totalCalculatedAmount": 650.00,
		    "environment": "8000 rest template"
		}
	 */
	
//===================================================================================================================================
	
	//  Using Feign:
	//  localhost:8100/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
				
		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment() + " " + "Feign");
		
	}
	
	/*
	 * 	Response: 
	 * 
	    {
		    "id": 2,
		    "from": "USD",
		    "to": "INR",
		    "quantity": 10,
		    "conversionMultiple": 65.00,
		    "totalCalculatedAmount": 650.00,
		    "environment": "800(0-1-2) rest template"
		}
	 */
	
//===============================================================================================================================

}
