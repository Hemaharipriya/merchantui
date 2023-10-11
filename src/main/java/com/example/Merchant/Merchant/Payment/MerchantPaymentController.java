package com.example.Merchant.Merchant.Payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@CrossOrigin
public class MerchantPaymentController {
	
	@Autowired
	private MerchantPaymentService merchantPaymentService;
	
	@RequestMapping(method=RequestMethod.POST, value="/payment")
	public ResponseEntity<String> addPaymentDetails(@RequestBody Payment merchantPayment) {
		if(merchantPayment == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please send amount in USD");
		}
		
		var p = merchantPaymentService.addPaymentDetails(merchantPayment);
		
		if(p == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please send amount in USD");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Added successfully");
		
	}
	
	
	@RequestMapping("/getRequest")
	public List<Payment> getAllData() {
		System.out.println("hhhhh");
		
//		WebClient.Builder builder = WebClient.builder();
//		merchantPaymentService.getPaymentData();
		
		return merchantPaymentService.getPaymentData();
		
		
	}
	
	@RequestMapping("/paymentStatus/{orderId}")
	public ResponseEntity<String> getPaymentStatus(@PathVariable int orderId) {
		var res = merchantPaymentService.getPaymentStatus(orderId);
//		System.out.println(res);
		if(res == "Failed") {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Payment Failed");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body("Payment Success");
		}
		
	}
}
