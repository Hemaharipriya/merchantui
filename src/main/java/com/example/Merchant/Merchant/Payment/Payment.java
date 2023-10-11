package com.example.Merchant.Merchant.Payment;

public class Payment {
		
		private int orderId;
		private int merchantId;
		private float amount;
		private String currency;

		public Payment() {
			
		}
		
		public Payment(int orderId, float amount, String currency, int merchantId) {
			super();
			this.amount = amount;
			this.currency = currency;
			this.orderId = orderId;
			this.merchantId = merchantId;
		}
		
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getMerchantId() {
			return merchantId;
		}

		public void setMerchantId(int merchantId) {
			this.merchantId = merchantId;
		}

		@Override
		public String toString() {
			return "MerchantPayment [orderId=" + orderId + ", merchantId=" + merchantId + ", amount=" + amount
					+ ", currency=" + currency + "]";
		}

		
		
	}
