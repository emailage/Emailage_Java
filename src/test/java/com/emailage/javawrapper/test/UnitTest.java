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


		input.setAcceptLang("en");
		assertEquals(input.getAcceptLang(), "en");

		input.setBillAddress("123 Main St");
		assertEquals(input.getBillAddress(), "123 Main St");

		input.setBillCity("Scottsdale");
		assertEquals(input.getBillCity(), "Scottsdale");

		input.setBillCountry("US");
		assertEquals(input.getBillCountry(), "US");
		input.setBillPostal("85255");
		assertEquals(input.getBillPostal(), "85255");

		input.setBillRegion("AZ");
		assertEquals(input.getBillRegion(), "AZ");

		input.setCustom1("custom1");
		assertEquals(input.getCustom1(), "custom1");

		input.setCustom2("cust2");
		assertEquals(input.getCustom2(), "cust2");

		input.setCustomerId("2341242");
		assertEquals(input.getCustomerId(), "2341242");

		input.setDeliveryType("sdf");
		assertEquals(input.getDeliveryType(), "sdf");

		input.setDeviceId("12345");
		assertEquals(input.getDeviceId(), "12345");

		input.setDeviceSource("iphone");
		assertEquals(input.getDeviceSource(), "iphone");

		input.setExistingCustomer(true);
		assertTrue(input.getExistingCustomer());

		input.setFirstName("john");
		assertEquals(input.getFirstName(), "john");

		input.setLastName("smith");
		assertEquals(input.getLastName(), "smith");

		input.setPhone("4805555555");
		assertEquals(input.getPhone(), "4805555555");

		input.setResponseLanguage("en");
		assertEquals(input.getResponseLanguage(), "en");

		input.setSecondaryEmail("junit@junit.com");
		assertEquals(input.getSecondaryEmail(), "junit@junit.com");

		input.setServiceCategory("cat1");
		assertEquals(input.getServiceCategory(), "cat1");

		input.setServiceDate("2018-10-28T22:15:00+00:00");
		assertEquals(input.getServiceDate(), "2018-10-28T22:15:00+00:00");

		input.setServiceDetail("aaa");
		assertEquals(input.getServiceDetail(), "aaa");

		input.setServiceLocation("bbb");
		assertEquals(input.getServiceLocation(), "bbb");

		input.setShipAddress("add 1");
		assertEquals(input.getShipAddress(), "add 1");

		input.setShipCity("houston");
		assertEquals(input.getShipCity(), "houston");

		input.setShipCountry("us");
		assertEquals(input.getShipCountry(), "us");


		input.setShipPostal("12345");
		assertEquals(input.getShipPostal(), "12345");

		input.setTransAmount(23.20);
		assertEquals(23.20, input.getTransAmount(), 0.0);


		input.setShipRegion("az");
		assertEquals(input.getShipRegion(), "az");

		input.setTimeToService(123);
		assertEquals(input.getTimeToService(), 123);


		input.setTransCurrency("USD");
		assertEquals(input.getTransCurrency(), "USD");

		input.setTransOrigin("us");
		assertEquals(input.getTransOrigin(), "us");

		input.setUrId("123124156");
		assertEquals(input.getUrId(), "123124156");

		input.setUserEmail("abc123@gmail.com");
		assertEquals(input.getUserEmail(), "abc123@gmail.com");

		input.setUserAgent("iphone");
		assertEquals(input.getUserAgent(), "iphone");

		input.setCardFirstSix("123456");
		assertEquals(input.getCardFirstSix(), "123456");

		input.setHashedCardNumber("hashedcardnumberhere");
		assertEquals(input.getHashedCardNumber(), "hashedcardnumberhere");

	}


}
