package com.emailage.javawrapper.test;

import com.emailage.javawrapper.model.ExtraInputParameter;
import com.emailage.javawrapper.utilities.Validation;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
	@Test
	public void testEmailValidation() {
		assertTrue(Validation.validateEmail("user@gmail.com"));
		assertTrue(Validation.validateEmail("user.x@gmail.com"));
		assertTrue(Validation.validateEmail("user.a@gmail.co.uk"));
		assertTrue(Validation.validateEmail("user.c@gmail.xyz"));
		assertTrue(Validation.validateEmail("user.2+1@gmail.xyz"));
		assertFalse(Validation.validateEmail("user@gmail"));
		assertFalse(Validation.validateEmail("user.1+1@gmail"));
		assertFalse(Validation.validateEmail("*(#(user.c+1@gmail.com"));
	}

	@Test
	public void testIpValidation() {

		//IPV4
		assertTrue(Validation.validateIpAddress("123.123.123.123"));
		assertTrue(Validation.validateIpAddress("255.123.123.123"));
		assertTrue(Validation.validateIpAddress("0.0.0.0"));
		assertTrue(Validation.validateIpAddress("1.0.0.255"));

		assertFalse(Validation.validateIpAddress("256.123.123.123"));
		assertFalse(Validation.validateIpAddress("256.123.123.0"));

		//IPV6
		assertTrue(Validation.validateIpAddress("2001:db8::1"));
		assertTrue(Validation.validateIpAddress("2001:0db8::0001"));
		assertTrue(Validation.validateIpAddress("2001:db8:0:0:0:0:2:1"));
		assertTrue(Validation.validateIpAddress("::"));
		assertTrue(Validation.validateIpAddress("0:0:0:0:0:0:0:0"));

		assertFalse(Validation.validateIpAddress("0:0:0:0:0:0:0:z"));
		assertFalse(Validation.validateIpAddress("jklsdf"));
		assertFalse(Validation.validateIpAddress("g:0:0:0:0:0:0:0"));
		assertFalse(Validation.validateIpAddress("0:0:0:0:ab:0:1"));
	}

	@Test
	public void testExtraInputParameters() throws Exception {
		ExtraInputParameter input = new ExtraInputParameter();


		input.setAcceptlang("en");
		assertEquals(input.getAcceptlang(), "en");

		input.setBilladdress("123 Main St");
		assertEquals(input.getBilladdress(), "123 Main St");

		input.setBillcity("Scottsdale");
		assertEquals(input.getBillcity(), "Scottsdale");

		input.setBillcountry("US");
		assertEquals(input.getBillcountry(), "US");
		input.setBillpostal("85255");
		assertEquals(input.getBillpostal(), "85255");

		input.setBillregion("AZ");
		assertEquals(input.getBillregion(), "AZ");

		input.setCustom1("custom1");
		assertEquals(input.getCustom1(), "custom1");

		input.setCustom2("cust2");
		assertEquals(input.getCustom2(), "cust2");

		input.setCustomerid("2341242");
		assertEquals(input.getCustomerid(), "2341242");

		input.setDelivery_type("sdf");
		assertEquals(input.getDelivery_type(), "sdf");

		input.setDeviceid("12345");
		assertEquals(input.getDeviceid(), "12345");

		input.setDevicesource("iphone");
		assertEquals(input.getDevicesource(), "iphone");

		input.setExistingcustomer(true);
		assertTrue(input.getExistingcustomer());

		input.setFirstname("john");
		assertEquals(input.getFirstname(), "john");

		input.setLastname("smith");
		assertEquals(input.getLastname(), "smith");

		input.setPhone("4805555555");
		assertEquals(input.getPhone(), "4805555555");

		input.setResponse_language("en");
		assertEquals(input.getResponse_language(), "en");

		input.setSecondary_email("junit@junit.com");
		assertEquals(input.getSecondary_email(), "junit@junit.com");

		input.setService_category("cat1");
		assertEquals(input.getService_category(), "cat1");

		input.setService_date("2018-10-28T22:15:00+00:00");
		assertEquals(input.getService_date(), "2018-10-28T22:15:00+00:00");

		input.setService_detail("aaa");
		assertEquals(input.getService_detail(), "aaa");

		input.setService_location("bbb");
		assertEquals(input.getService_location(), "bbb");

		input.setShipaddress("add 1");
		assertEquals(input.getShipaddress(), "add 1");

		input.setShipcity("houston");
		assertEquals(input.getShipcity(), "houston");

		input.setShipcountry("us");
		assertEquals(input.getShipcountry(), "us");


		input.setShippostal("12345");
		assertEquals(input.getShippostal(), "12345");

		input.setTransamount(23.20);
		assertEquals(23.20, input.getTransamount(), 0.0);


		input.setShipregion("az");
		assertEquals(input.getShipregion(), "az");

		input.setTime_to_service(123);
		assertEquals(input.getTime_to_service(), 123);


		input.setTranscurrency("USD");
		assertEquals(input.getTranscurrency(), "USD");

		input.setTransorigin("us");
		assertEquals(input.getTransorigin(), "us");

		input.setUrid("123124156");
		assertEquals(input.getUrid(), "123124156");

		input.setUser_email("abc123@gmail.com");
		assertEquals(input.getUser_email(), "abc123@gmail.com");

		input.setUseragent("iphone");
		assertEquals(input.getUseragent(), "iphone");

		input.setCardfirstsix("123456");
		assertEquals(input.getCardfirstsix(), "123456");

		input.setHashedcardnumber("hashedcardnumberhere");
		assertEquals(input.getHashedcardnumber(), "hashedcardnumberhere");

	}


}
