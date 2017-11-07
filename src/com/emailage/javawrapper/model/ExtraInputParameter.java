package com.emailage.javawrapper.model;

import java.lang.reflect.Field;

public class ExtraInputParameter {
	private String firstname = new String();

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String value) {
		firstname = value;
	}

	private String lastname = new String();

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String value) {
		lastname = value;
	}

	private String billaddress = new String();

	public String getbilladdress() {
		return billaddress;
	}

	public void setbilladdress(String value) {
		billaddress = value;
	}

	private String billcity = new String();

	public String getbillcity() {
		return billcity;
	}

	public void setbillcity(String value) {
		billcity = value;
	}

	private String billregion = new String();

	public String getbillregion() {
		return billregion;
	}

	public void setbillregion(String value) {
		billregion = value;
	}

	private String billpostal = new String();

	public String getbillpostal() {
		return billpostal;
	}

	public void setbillpostal(String value) {
		billpostal = value;
	}

	private String billcountry = new String();

	public String getbillcountry() {
		return billcountry;
	}

	public void setbillcountry(String value) {
		billcountry = value;
	}

	private String shipaddress = new String();

	public String getshipaddress() {
		return shipaddress;
	}

	public void setshipaddress(String value) {
		shipaddress = value;
	}

	private String shipcity = new String();

	public String getshipcity() {
		return shipcity;
	}

	public void setshipcity(String value) {
		shipcity = value;
	}

	private String shipregion = new String();

	public String getshipregion() {
		return shipregion;
	}

	public void setshipregion(String value) {
		shipregion = value;
	}

	private String shippostal = new String();

	public String getshippostal() {
		return shippostal;
	}

	public void setshippostal(String value) {
		shippostal = value;
	}

	private String shipcountry = new String();

	public String getshipcountry() {
		return shipcountry;
	}

	public void setshipcountry(String value) {
		shipcountry = value;
	}

	private String phone = new String();

	public String getphone() {
		return phone;
	}

	public void setphone(String value) {
		phone = value;
	}

	private double transamount;

	public double gettransamount() {
		return transamount;
	}

	public void settransamount(double value) {
		transamount = value;
	}

	private String transcurrency = new String();

	public String gettranscurrency() {
		return transcurrency;
	}

	public void settranscurrency(String value) {
		transcurrency = value;
	}

	private String transorigin = new String();

	public String gettransorigin() {
		return transorigin;
	}

	public void settransorigin(String value) {
		transorigin = value;
	}

	private boolean existingcustomer;

	public boolean getexistingcustomer() {
		return existingcustomer;
	}

	public void setexistingcustomer(boolean value) {
		existingcustomer = value;
	}

	private String useragent = new String();

	public String getuseragent() {
		return useragent;
	}

	public void setuseragent(String value) {
		useragent = value;
	}

	private String acceptlang = new String();

	public String getacceptlang() {
		return acceptlang;
	}

	public void setacceptlang(String value) {
		acceptlang = value;
	}

	private String customerid = new String();

	public String getcustomerid() {
		return customerid;
	}

	public void setcustomerid(String value) {
		customerid = value;
	}

	private String urid = new String();

	public String geturid() {
		return urid;
	}

	public void seturid(String value) {
		urid = value;
	}



	private String deviceid = new String();

	public String getdeviceid() {
		return deviceid;
	}

	public void setdeviceid(String value) {
		deviceid = value;
	}

	private String devicesource = new String();

	public String getdevicesource() {
		return devicesource;
	}

	public void setdevicesource(String value) {
		devicesource = value;
	}

	private String response_language = new String();

	public String getresponse_language() {
		return response_language;
	}

	public void setresponse_language(String value) {
		response_language = value;
	}

	private String user_email = new String();

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String value) {
		user_email = value;
	}

	private String secondary_email = new String();

	public void setsecondary_email(String value) {
		secondary_email = value;
	}
	public String getsecondary_email() {
		return secondary_email;
	}

	private String service_category = new String();
	
	public void setservice_category(String value) {
		service_category = value;
	}
	public String getservice_category() {
		return service_category;
	}

	
	private String service_date = new String();
	
	public void setservice_date(String value) {
		service_date = value;
	}
	public String getservice_date() {
		return service_date;
	}

	private String service_detail = new String();
	
	public void setservice_detail(String value) {
		service_detail = value;
	}
	public String getservice_detail() {
		return service_detail;
	}
	
	private String service_location = new String();
	
	public void setservice_location(String value) {
		service_location = value;
	}
	public String getservice_location() {
		return service_location;
	}

	private int time_to_service;
	
	public void settime_to_service(int value) {
		time_to_service = value;
	}	
	public int gettime_to_service() {
		return time_to_service;
	}
	
	private String delivery_type = new String();
	
	public void setdelivery_type(String value) {
		delivery_type = value;
	}	
	public String getdelivery_type() {
		return delivery_type;
	}


	private String custom1 = new String();
	
	public void setcustom1(String value) {
		custom1 = value;
	}	
	public String getcustom1() {
		return custom1;
	}


	private String custom2 = new String();
	
	public void setcustom2(String value) {
		custom2 = value;
	}	
	public String getcustom2() {
		return custom2;
	}
	
	
	public String buildExtraInputParameterRequest() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (Field prop : ExtraInputParameter.class.getDeclaredFields()) {
			if (prop.getType().getSimpleName().equals("String")) {
				prop.setAccessible(true);

				String strValue = (String) prop.get(this);
				if (!strValue.equals("")) {
					sb.append(String.format("&%s=%s", prop.getName(), strValue));
				}

			}
			// below two statements are not used for now unless we want to add
			// the support
			// of the types other string.
			else if (prop.getType().toString().equals("boolean")) {
				prop.setAccessible(true);
				boolean value = (boolean) prop.get(this);
				sb.append(String.format("&%s=%b", prop.getName(), value));
			} else if (prop.getType().toString().equals("double")) {
				prop.setAccessible(true);
				double value = (double) prop.get(this);
				sb.append(String.format("&%s=%f", prop.getName(), value));
			}

		}
		return sb.toString();
	}

}
