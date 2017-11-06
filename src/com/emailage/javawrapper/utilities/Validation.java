package com.emailage.javawrapper.utilities;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.InetAddressValidator;

public class Validation {

	public static boolean validateEmail(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	public static boolean validateIpAddress(String ipAddress) {
		return InetAddressValidator.getInstance().isValid(ipAddress);
	}
}
