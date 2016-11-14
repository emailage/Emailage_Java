package com.emailage.javawrapper.model;

public class Enums {
	public enum Environment {
		Sandbox, Production
	}

	public enum Format {
		Json, Xml;

		@Override
		public String toString() {

			if (this == Json)
				return "json";
			else
				return "xml";

		}
	}

	public enum FraudFlag {
		Good, Fraud, Neutral;

		@Override
		public String toString() {

			if (this == Good)
				return "good";
			else if (this == Fraud)
				return "fraud";
			else
				return "neutral";

		}
	}

	public enum SignatureMethod {
		HMAC_SHA1, HMAC_SHA256, HMAC_SHA384, HMAC_SHA512;

		@Override
		public String toString() {
			if (Enums.SignatureMethod.HMAC_SHA1 == this) {
				return "HMAC-SHA1";
			} else if (Enums.SignatureMethod.HMAC_SHA256 == this) {
				return "HMAC-SHA256";
			} else if (Enums.SignatureMethod.HMAC_SHA384 == this) {
				return "HMAC-SHA384";
			} else {
				return "HMAC-SHA512";
			}
		}
	}

}
