package com.emailage.javawrapper.model;

import com.emailage.javawrapper.model.exception.EmailageParameterException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtraInputParameter {

	private String firstname;
	private String lastname;
	private String billaddress;
	private String billcity;
	private String billregion;
	private String billpostal;
	private String billcountry;
	private String shipaddress;
	private String shipcity;
	private String shipregion;
	private String shippostal;
	private String shipcountry;
	private String phone;
	private double transamount;
	private String transcurrency;
	private String transorigin;
	private boolean existingcustomer;
	private String useragent;
	private String acceptlang;
	private String customerid;
	private String urid;
	private String delivery_type;
	private String deviceid;
	private String devicesource;
	private String response_language;
	private String user_email;
	private String secondary_email;
	private String service_category;
	private String service_date;
	private String service_detail;
	private String service_location;
	private int time_to_service;
	private String custom1;
	private String custom2;
	private String cardfirstsix;
	private String hashedcardnumber;


	public String getFirstname() {
		return firstname;
	}

	@JsonProperty("firstname")
	public void setFirstname(String value) {
		firstname = value;
	}

	public String getLastname() {
		return lastname;
	}

	@JsonProperty("lastname")
	public void setLastname(String value) {
		lastname = value;
	}

	public String getBilladdress() {
		return billaddress;
	}

	@JsonProperty("billaddress")
	public void setBilladdress(String value) {
		billaddress = value;
	}

	public String getBillcity() {
		return billcity;
	}

	@JsonProperty("billcity")
	public void setBillcity(String value) {
		billcity = value;
	}

	public String getBillregion() {
		return billregion;
	}

	@JsonProperty("billregion")
	public void setBillregion(String value) {
		billregion = value;
	}

	public String getBillpostal() {
		return billpostal;
	}

	@JsonProperty("billpostal")
	public void setBillpostal(String value) {
		billpostal = value;
	}

	public String getBillcountry() {
		return billcountry;
	}

	@JsonProperty("billcountry")
	public void setBillcountry(String value) {
		billcountry = value;
	}

	public String getShipaddress() {
		return shipaddress;
	}

	@JsonProperty("shipaddress")
	public void setShipaddress(String value) {
		shipaddress = value;
	}

	public String getShipcity() {
		return shipcity;
	}

	@JsonProperty("shipcity")
	public void setShipcity(String value) {
		shipcity = value;
	}

	public String getShipregion() {
		return shipregion;
	}

	@JsonProperty("shipregion")
	public void setShipregion(String value) {
		shipregion = value;
	}

	public String getShippostal() {
		return shippostal;
	}

	@JsonProperty("shippostal")
	public void setShippostal(String value) {
		shippostal = value;
	}


	public String getShipcountry() {
		return shipcountry;
	}

	@JsonProperty("shipcountry")
	public void setShipcountry(String value) {
		shipcountry = value;
	}

	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String value) {
		phone = value;
	}

	public double getTransamount() {
		return transamount;
	}

	@JsonProperty("transamount")
	public void setTransamount(double value) {
		transamount = value;
	}

	public String getTranscurrency() {
		return transcurrency;
	}

	@JsonProperty("transcurrency")
	public void setTranscurrency(String value) {
		transcurrency = value;
	}

	public String getTransorigin() {
		return transorigin;
	}

	@JsonProperty("transorigin")
	public void setTransorigin(String value) {
		transorigin = value;
	}

	public boolean getExistingcustomer() {
		return existingcustomer;
	}

	@JsonProperty("existingcustomer")
	public void setExistingcustomer(boolean value) {
		existingcustomer = value;
	}

	public String getUseragent() {
		return useragent;
	}

	@JsonProperty("useragent")
	public void setUseragent(String value) {
		useragent = value;
	}

	public String getAcceptlang() {
		return acceptlang;
	}

	@JsonProperty("acceptlang")
	public void setAcceptlang(String value) {
		acceptlang = value;
	}

	public String getCustomerid() {
		return customerid;
	}

	@JsonProperty("customerid")
	public void setCustomerid(String value) {
		customerid = value;
	}

	public String getUrid() {
		return urid;
	}

	@JsonProperty("urid")
	public void setUrid(String value) {
		urid = value;
	}

	public String getDeviceid() {
		return deviceid;
	}

	@JsonProperty("deviceid")
	public void setDeviceid(String value) {
		deviceid = value;
	}

	public String getDevicesource() {
		return devicesource;
	}

	@JsonProperty("devicesource")
	public void setDevicesource(String value) {
		devicesource = value;
	}

	public String getResponse_language() {
		return response_language;
	}

	@JsonProperty("response_language")
	public void setResponse_language(String value) {
		response_language = value;
	}

	public String getUser_email() {
		return user_email;
	}

	@JsonProperty("user_email")
	public void setUser_email(String value) {
		user_email = value;
	}

	public String getSecondary_email() {
		return secondary_email;
	}

	@JsonProperty("secondary_email")
	public void setSecondary_email(String value) {
		secondary_email = value;
	}

	public String getService_category() {
		return service_category;
	}

	@JsonProperty("service_category")
	public void setService_category(String value) {
		service_category = value;
	}

	public String getService_date() {
		return service_date;
	}

	@JsonProperty("service_date")
	public void setService_date(String value) {
		service_date = value;
	}


	public String getService_detail() {
		return service_detail;
	}

	@JsonProperty("service_detail")
	public void setService_detail(String value) {
		service_detail = value;
	}

	public String getService_location() {
		return service_location;
	}

	@JsonProperty("service_location")
	public void setService_location(String value) {
		service_location = value;
	}

	public int getTime_to_service() {
		return time_to_service;
	}

	@JsonProperty("time_to_service")
	public void setTime_to_service(int value) {
		time_to_service = value;
	}

	public String getDelivery_type() {
		return delivery_type;
	}

	@JsonProperty("delivery_type")
	public void setDelivery_type(String value) {
		delivery_type = value;
	}

	public String getCustom1() {
		return custom1;
	}

	@JsonProperty("custom1")
	public void setCustom1(String value) {
		custom1 = value;
	}

	public String getCustom2() {
		return custom2;
	}

	@JsonProperty("custom2")
	public void setCustom2(String value) {
		custom2 = value;
	}

	public String getCardfirstsix() {
		return cardfirstsix;
	}

	@JsonProperty("cardfirstsix")
	public void setCardfirstsix(String value) {
		cardfirstsix = value;
	}

	public String getHashedcardnumber() {
		return hashedcardnumber;
	}

	@JsonProperty("hashedcardnumber")
	public void setHashedcardnumber(String value) {
		hashedcardnumber = value;
	}

	public String buildExtraInputParameterRequest()
			throws EmailageParameterException {
		StringBuilder sb = new StringBuilder();
		try {
			for (Field prop : ExtraInputParameter.class.getDeclaredFields()) {
				if (prop.getType().getSimpleName().equals("String")) {
					prop.setAccessible(true);

					String strValue = (String) prop.get(this);
					if (strValue!=null && !strValue.equals("")) {
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
