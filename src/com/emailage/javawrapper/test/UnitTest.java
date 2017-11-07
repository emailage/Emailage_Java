package com.emailage.javawrapper.test;
import static org.junit.Assert.*;
import org.junit.Test;

import com.emailage.javawrapper.model.ExtraInputParameter;
import com.emailage.javawrapper.utilities.Validation;

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
		assertTrue(Validation.validateIpAddress("123.123.123.123"));
		assertTrue(Validation.validateIpAddress("255.123.123.123"));
		assertFalse(Validation.validateIpAddress("256.123.123.123"));
		assertFalse(Validation.validateIpAddress("256.123.123.0"));
		assertTrue(Validation.validateIpAddress("0.0.0.0"));
		assertTrue(Validation.validateIpAddress("1.0.0.255"));
		assertTrue(Validation.validateIpAddress("2001:db8::1"));
		assertTrue(Validation.validateIpAddress("2001:0db8::0001"));
		assertTrue(Validation.validateIpAddress("2001:db8:0:0:0:0:2:1"));
		assertTrue(Validation.validateIpAddress("::"));
		assertTrue(Validation.validateIpAddress("0:0:0:0:0:0:0:0"));
	}

	@Test
	public void testExtraInputParameters() throws Exception {
		ExtraInputParameter input = new ExtraInputParameter();

		
		input.setacceptlang("en");
		assertEquals(input.getacceptlang(), "en");

		input.setbilladdress("123 Main St");
		assertEquals(input.getbilladdress(), "123 Main St");

		input.setbillcity("Scottsdale");
		assertEquals(input.getbillcity(), "Scottsdale");

		input.setbillcountry("US");
		assertEquals(input.getbillcountry(), "US");
		input.setbillpostal("85255");
		assertEquals(input.getbillpostal(), "85255");

		input.setbillregion("AZ");
		assertEquals(input.getbillregion(), "AZ");

		input.setcustom1("custom1");
		assertEquals(input.getcustom1(), "custom1");

		input.setcustom2("cust2");
		assertEquals(input.getcustom2(), "cust2");

		input.setcustomerid("2341242");
		assertEquals(input.getcustomerid(), "2341242");

		input.setdelivery_type("sdf");
		assertEquals(input.getdelivery_type(), "sdf");

		input.setdeviceid("12345");
		assertEquals(input.getdeviceid(), "12345");

		input.setdevicesource("iphone");
		assertEquals(input.getdevicesource(), "iphone");

		input.setexistingcustomer(true);
		assertTrue(input.getexistingcustomer());

		input.setfirstname("john");
		assertEquals(input.getfirstname(), "john");

		input.setlastname("smith");
		assertEquals(input.getlastname(), "smith");

		input.setphone("4805555555");
		assertEquals(input.getphone(), "4805555555");

		input.setresponse_language("en");
		assertEquals(input.getresponse_language(), "en");

		input.setsecondary_email("junit@junit.com");
		assertEquals(input.getsecondary_email(), "junit@junit.com");

		input.setservice_category("cat1");
		assertEquals(input.getservice_category(), "cat1");		
		
		input.setservice_date("2018-10-28T22:15:00+00:00");
		assertEquals(input.getservice_date(), "2018-10-28T22:15:00+00:00");

		input.setservice_detail("aaa");
		assertEquals(input.getservice_detail(), "aaa");

		input.setservice_location("bbb");
		assertEquals(input.getservice_location(), "bbb");

		input.setshipaddress("add 1");
		assertEquals(input.getshipaddress(), "add 1");

		input.setshipcity("houston");
		assertEquals(input.getshipcity(), "houston");

		input.setshipcountry("us");
		assertEquals(input.getshipcountry(), "us");

		
		input.setshippostal("12345");
		assertEquals(input.getshippostal(), "12345");

		input.settransamount(23.20);
		assertTrue(input.gettransamount() == 23.20);
		

		input.setshipregion("az");
		assertEquals(input.getshipregion(), "az");

		input.settime_to_service(123);
		assertEquals(input.gettime_to_service(), 123);


		input.settranscurrency("USD");
		assertEquals(input.gettranscurrency(), "USD");

		input.settransorigin("us");
		assertEquals(input.gettransorigin(), "us");

		input.seturid("123124156");
		assertEquals(input.geturid(), "123124156");

		input.setuser_email("abc123@gmail.com");
		assertEquals(input.getuser_email(), "abc123@gmail.com");

		input.setuseragent("iphone");
		assertEquals(input.getuseragent(), "iphone");

		String request = input.buildExtraInputParameterRequest();
		assertEquals(request, "&firstname=john&lastname=smith&billaddress=123 Main St&billcity=Scottsdale&billregion=AZ&billpostal=85255&billcountry=US&shipaddress=add 1&shipcity=houston&shipregion=az&shippostal=12345&shipcountry=us&phone=4805555555&transamount=23.200000&transcurrency=USD&transorigin=us&existingcustomer=true&useragent=iphone&acceptlang=en&customerid=2341242&urid=123124156&deviceid=12345&devicesource=iphone&response_language=en&user_email=abc123@gmail.com&secondary_email=junit@junit.com&service_category=cat1&service_date=2018-10-28T22:15:00+00:00&service_detail=aaa&service_location=bbb&delivery_type=sdf&custom1=custom1&custom2=cust2");
	}


}
