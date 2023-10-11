package com.example.Merchant.Merchant.Registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantRegistrationController {
	
	@Autowired
	private MerchantRegistrationService merchantRegistrationService;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public ResponseEntity<String> addMerchant(@RequestBody MerchantRegistration merchantRegistration) {
		var p = merchantRegistrationService.addMerchantData(merchantRegistration);
//		System.out.println(p);
//		System.out.println(paymentGatewayRegistration.getMerchantId());
		if(p == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merchant Alreay Existed");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added Merchant Data");
	}
	
	@RequestMapping("/getMerchant")
	public ResponseEntity<List<MerchantRegistration>> getMerchantData() {
		var p = merchantRegistrationService.getMerchantData();
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
}
