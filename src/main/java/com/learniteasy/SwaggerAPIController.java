package com.learniteasy;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SwaggerAPIController {

	private final Logger LOG = Logger.getLogger(SwaggerAPIController.class.getName());

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}

	@GetMapping(value = "/zipkin")
	public String zipkinService1() {
		LOG.info("Inside zipkinService 1..");

		String response = (String) restTemplate.exchange("http://localhost:8081/zipkin1", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();
		return "Hi...";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<String> getProducts() {
		List<String> productsList = new ArrayList<>();
		productsList.add("Honey");
		productsList.add("Almond");
		return productsList;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String createProduct() {
		return "Product is saved successfully";
	}

}