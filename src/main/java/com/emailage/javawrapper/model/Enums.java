package com.emailage.javawrapper.model;

public class Enums {
	public enum Environment {
		Sandbox, Production
	}

	public enum Format {
		Json("json"),
		Xml("xml");

		String name;

		Format(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	public enum FraudType {
		Good("good"),
		Fraud("fraud"),
		Neutral("neutral");

		private String name;

		FraudType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	public enum SignatureMethod {
		HMAC_SHA1("HMAC-SHA1"),
		HMAC_SHA256("HMAC-SHA256"),
		HMAC_SHA384("HMAC-SHA384"),
		HMAC_SHA512("HMAC-SHA512");

		private String name;

		SignatureMethod(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	public enum FraudCode {
		/** Card Not Present */
		CARD_NOT_PRESENT("Card Not Present",1),
		/** Customer Dispute (Chargeback) */
		CUSTOMER_DISPUTE("Customer Dispute (Chargeback)", 2),
		/** First Party Fraud */
		FIRST_PARTY_FRAUD("First Party Fraud",3),
		/** First Payment Default */
		FIRST_PAYMENT_DEFAULT("First Payment Default",4),
		/** Identity Theft (Fraud Application) */
		IDENTITY_THEFT_APPLICATION("Identity Theft (Fraud Application)",5),
		/** Identity Theft (Account Take Over) */
		IDENTITY_THEFT_ACCOUNT_TAKE_OVER("Identity Theft (Account Take Over)",6),
		/** Suspected Fraud (Not Confirmed) */
		SUSPECTED_FRAUD("Suspected Fraud (Not Confirmed)",7),
		/** Synthetic ID */
		SYNTHETIC_ID("Synthetic ID",8),
		/** Other */
		OTHER("Other",9);

		private final String name;
		private final int value;

		FraudCode(String name, int value){
			this.name = name;
			this.value = value;
		}
		@Override
		public String toString(){
			return this.name;
		}
		public int toInt(){
			return this.value;
		}
	}

}
