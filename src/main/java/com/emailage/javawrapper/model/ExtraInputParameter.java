package com.emailage.javawrapper.model;

import java.lang.reflect.Field;

public class ExtraInputParameter {
	private String firstname = "";

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String value) {
		firstname = value;
	}

	private String lastname = "";

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String value) {
		lastname = value;
	}

	private String billaddress = "";

	public String getbilladdress() {
		return billaddress;
	}

	public void setbilladdress(String value) {
		billaddress = value;
	}

	private String billcity = "";

	public String getbillcity() {
		return billcity;
	}

	public void setbillcity(String value) {
		billcity = value;
	}

	private String billregion = "";

	public String getbillregion() {
		return billregion;
	}

	public void setbillregion(String value) {
		billregion = value;
	}

	private String billpostal = "";

	public String getbillpostal() {
		return billpostal;
	}

	public void setbillpostal(String value) {
		billpostal = value;
	}

	private String billcountry = "";

	public String getbillcountry() {
		return billcountry;
	}

	public void setbillcountry(String value) {
		billcountry = value;
	}

	private String shipaddress = "";

	public String getshipaddress() {
		return shipaddress;
	}

	public void setshipaddress(String value) {
		shipaddress = value;
	}

	private String shipcity = "";

	public String getshipcity() {
		return shipcity;
	}

	public void setshipcity(String value) {
		shipcity = value;
	}

	private String shipregion = "";

	public String getshipregion() {
		return shipregion;
	}

	public void setshipregion(String value) {
		shipregion = value;
	}

	private String shippostal = "";

	public String getshippostal() {
		return shippostal;
	}

	public void setshippostal(String value) {
		shippostal = value;
	}

	private String shipcountry = "";

	public String getshipcountry() {
		return shipcountry;
	}

	public void setshipcountry(String value) {
		shipcountry = value;
	}

	private String phone = "";

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

	private String transcurrency = "";

	public String gettranscurrency() {
		return transcurrency;
	}

	public void settranscurrency(String value) {
		transcurrency = value;
	}

	private String transorigin = "";

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

	private String useragent = "";

	public String getuseragent() {
		return useragent;
	}

	public void setuseragent(String value) {
		useragent = value;
	}

	private String acceptlang = "";

	public String getacceptlang() {
		return acceptlang;
	}

	public void setacceptlang(String value) {
		acceptlang = value;
	}

	private String customerid = "";

	public String getcustomerid() {
		return customerid;
	}

	public void setcustomerid(String value) {
		customerid = value;
	}

	private String urid = "";

	public String geturid() {
		return urid;
	}

	public void seturid(String value) {
		urid = value;
	}



	private String deviceid = "";

	public String getdeviceid() {
		return deviceid;
	}

	public void setdeviceid(String value) {
		deviceid = value;
	}

	private String devicesource = "";

	public String getdevicesource() {
		return devicesource;
	}

	public void setdevicesource(String value) {
		devicesource = value;
	}

	private String response_language = "";

	public String getresponse_language() {
		return response_language;
	}

	public void setresponse_language(String value) {
		response_language = value;
	}

	private String user_email = "";

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String value) {
		user_email = value;
	}

	private String secondary_email = "";

	public void setsecondary_email(String value) {
		secondary_email = value;
	}
	public String getsecondary_email() {
		return secondary_email;
	}

	private String service_category = "";
	
	public void setservice_category(String value) {
		service_category = value;
	}
	public String getservice_category() {
		return service_category;
	}

	
	private String service_date = "";
	
	public void setservice_date(String value) {
		service_date = value;
	}
	public String getservice_date() {
		return service_date;
	}

	private String service_detail = "";
	
	public void setservice_detail(String value) {
		service_detail = value;
	}
	public String getservice_detail() {
		return service_detail;
	}
	
	private String service_location = "";
	
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
	
	private String delivery_type = "";
	
	public void setdelivery_type(String value) {
		delivery_type = value;
	}	
	public String getdelivery_type() {
		return delivery_type;
	}


	private String custom1 = "";
	
	public void setcustom1(String value) {
		custom1 = value;
	}	
	public String getcustom1() {
		return custom1;
	}


	private String custom2 = "";
	
	public void setcustom2(String value) {
		custom2 = value;
	}	
	public String getcustom2() {
		return custom2;
	}
	
	private String cardFirstSix = "";
	
	public void setcardFirstSix(String value) {
		cardFirstSix = value;
	}	
	public String getcardFirstSix() {
		return cardFirstSix;
	}
	
	private String hashedCardNumber = "";
	
	public void sethashedCardNumber(String value) {
		hashedCardNumber = value;
	}	
	public String gethashedCardNumber() {
		return hashedCardNumber;
	}	
	
	
	
	public String buildExtraInputParameterRequest()
			throws EmailageParameterException {
		StringBuilder sb = new StringBuilder();
		try {
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
		} catch(Exception e){
			throw new EmailageParameterException("Could not parse extra input parameters for the request",e);
		}
		return sb.toString();
	}

}
