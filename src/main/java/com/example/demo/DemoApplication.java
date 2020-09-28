package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
 

	 @RequestMapping("/pub")
	 public String publish () {
		String vals = "2357";
		char od1 = vals.charAt((int)(Math.random() * 4));
		kafkaTemplate.send("baeldung", "new msg## "+od1);
		return "Hello Publisher";
		
	 }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
