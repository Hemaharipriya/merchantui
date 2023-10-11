package com.example.Merchant.Merchant.Registration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MerchantRegistrationService {
	private List<MerchantRegistration> merchants = new ArrayList<>();
	
	public List<MerchantRegistration> addMerchantData(MerchantRegistration merchantRegistration) {
//		System.out.println(merchantRegistration.getMerchantId());
		@SuppressWarnings("unlikely-arg-type")
		var alreadyExisted = merchants.contains(merchantRegistration.getMerchantId());
		if(!alreadyExisted) {
			merchants.add(merchantRegistration);
			return merchants;
		}
		System.out.println(merchants);
		return null;
	}
	public List<MerchantRegistration> getMerchantData(){
		return merchants;
	}
}
