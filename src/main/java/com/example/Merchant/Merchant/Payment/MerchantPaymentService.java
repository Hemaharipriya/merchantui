package com.example.Merchant.Merchant.Payment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class MerchantPaymentService {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	private Logger log = LoggerFactory.getLogger(Payment.class);
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	private List<Payment> payments = new ArrayList<>();
	
	public String addPaymentDetails(Payment merchantPayment) {
		if(merchantPayment.getCurrency().matches("USD")) {
			
			log.info("================================");
			log.info("merchant Payment req = {}", merchantPayment);
			log.info("================================");
			
			payments.add(merchantPayment);
						
			return webClientBuilder.build()
			.post()
			.uri("http://localhost:9090/payment")
			.accept(MediaType.APPLICATION_JSON)
			.body(Mono.just(merchantPayment), Payment.class)
			.retrieve()
			.bodyToMono(String.class)
			.block();
			
//			return payments;
		}
		return null;
	}
	
	public List<Payment> getPaymentData(){
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getForObject(null, null)t
//		System.out.println("fff");
		var result = webClientBuilder.build()
				.get()
				.uri("http://localhost:9090/getRequest")
				.retrieve()
				.bodyToMono(Payment[].class)
				.block();
		
		return List.of(result);
//		System.out.println("fff");
//		return payments;
	}
	
//	@SuppressWarnings("unlikely-arg-type")
	public String getPaymentStatus(int orderId){
		if(payments.stream().anyMatch(id -> id.getOrderId() == orderId)){
			return "Success";
		}
		else {
			return "Failed";
		}
		
	}
}
