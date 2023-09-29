package com.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CurrencyExchange;
import com.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

//=====================================================================================================================================
	
	//  localhost:8000/currency-exchange/from/{from}/to/{to}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchange(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
	
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	
	}
	
//======================================================================================================================================
	
	// localhost:8000/currency-exchange-value/from/{from}/to/{to}
	
	@GetMapping("/currency-exchange-value/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		//  INFO [currency-exchange-service,ebd4fd781101456570119151a21023e1,bcc14f12fffc2c4d][0;39m [35m10896[0;39m [2m---[0;39m [2m[nio-8001-exec-2][0;39m [36mc.controller.CurrencyExchangeController [0;39m [2m:[0;39m retrieveExchangeValue called with USD to INR
		logger.info("retrieveExchangeValue called with {} to {}", from, to);
		
		if(currencyExchange ==null) {
			throw new RuntimeException
				("Unable to Find data for " + from + " to " + to);
		}
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
		
	}
	
//====================================================================================================================================
		
	//  http://localhost:8000/getAll
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<CurrencyExchange> getAllCurrency() {
		return repository.findAll();
	}
	
//=======================================================================================================================================
	
	//  http://localhost:8000/store
	
	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public CurrencyExchange createProduct(@RequestBody CurrencyExchange currencyExchangeReq) {
		return repository.save(currencyExchangeReq);
	}
	
//========================================================================================================================================
}
