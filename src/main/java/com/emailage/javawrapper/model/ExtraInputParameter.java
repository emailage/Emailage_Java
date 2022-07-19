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
	private String custom3;
	private String custom4;
	private String custom5;
	private String custom6;
	private String custom7;
	private String cardfirstsix;
	private String hashedcardnumber;
	private String trackingId;
	private String pocPreProcessing;
	private int transactionTypeId;
	private String transactionTypeDescription;
	private String phoneCountryCode;
	private int ccBinNumber;

	public String getFirstName() {
		return firstname;
	}

	@JsonProperty("firstname")
	public void setFirstName(String value) {
		firstname = value;
	}

	public String getLastName() {
		return lastname;
	}

	@JsonProperty("lastname")
	public void setLastName(String value) {
		lastname = value;
	}

	public String getBillAddress() {
		return billaddress;
	}

	@JsonProperty("billaddress")
	public void setBillAddress(String value) {
		billaddress = value;
	}

	public String getBillCity() {
		return billcity;
	}

	@JsonProperty("billcity")
	public void setBillCity(String value) {
		billcity = value;
	}

	public String getBillRegion() {
		return billregion;
	}

	@JsonProperty("billregion")
	public void setBillRegion(String value) {
		billregion = value;
	}

	public String getBillPostal() {
		return billpostal;
	}

	@JsonProperty("billpostal")
	public void setBillPostal(String value) {
		billpostal = value;
	}

	public String getBillCountry() {
		return billcountry;
	}

	@JsonProperty("billcountry")
	public void setBillCountry(String value) {
		billcountry = value;
	}

	public String getShipAddress() {
		return shipaddress;
	}

	@JsonProperty("shipaddress")
	public void setShipAddress(String value) {
		shipaddress = value;
	}

	public String getShipCity() {
		return shipcity;
	}

	@JsonProperty("shipcity")
	public void setShipCity(String value) {
		shipcity = value;
	}

	public String getShipRegion() {
		return shipregion;
	}

	@JsonProperty("shipregion")
	public void setShipRegion(String value) {
		shipregion = value;
	}

	public String getShipPostal() {
		return shippostal;
	}

	@JsonProperty("shippostal")
	public void setShipPostal(String value) {
		shippostal = value;
	}


	public String getShipCountry() {
		return shipcountry;
	}

	@JsonProperty("shipcountry")
	public void setShipCountry(String value) {
		shipcountry = value;
	}

	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String value) {
		phone = value;
	}

	public double getTransAmount() {
		return transamount;
	}

	@JsonProperty("transamount")
	public void setTransAmount(double value) {
		transamount = value;
	}

	public String getTransCurrency() {
		return transcurrency;
	}

	@JsonProperty("transcurrency")
	public void setTransCurrency(String value) {
		transcurrency = value;
	}

	public String getTransOrigin() {
		return transorigin;
	}

	@JsonProperty("transorigin")
	public void setTransOrigin(String value) {
		transorigin = value;
	}

	public boolean getExistingCustomer() {
		return existingcustomer;
	}

	@JsonProperty("existingcustomer")
	public void setExistingCustomer(boolean value) {
		existingcustomer = value;
	}

	public String getUserAgent() {
		return useragent;
	}

	@JsonProperty("useragent")
	public void setUserAgent(String value) {
		useragent = value;
	}

	public String getAcceptLang() {
		return acceptlang;
	}

	@JsonProperty("acceptlang")
	public void setAcceptLang(String value) {
		acceptlang = value;
	}

	public String getCustomerId() {
		return customerid;
	}

	@JsonProperty("customerid")
	public void setCustomerId(String value) {
		customerid = value;
	}

	public String getUrid() {
		return urid;
	}

	@JsonProperty("urid")
	public void setUrid(String value) {
		urid = value;
	}

	public String getDeviceId() {
		return deviceid;
	}

	@JsonProperty("deviceid")
	public void setDeviceId(String value) {
		deviceid = value;
	}

	public String getDeviceSource() {
		return devicesource;
	}

	@JsonProperty("devicesource")
	public void setDeviceSource(String value) {
		devicesource = value;
	}

	public String getResponseLanguage() {
		return response_language;
	}

	@JsonProperty("response_language")
	public void setResponseLanguage(String value) {
		response_language = value;
	}

	public String getUserEmail() {
		return user_email;
	}

	@JsonProperty("user_email")
	public void setUserEmail(String value) {
		user_email = value;
	}

	public String getSecondaryEmail() {
		return secondary_email;
	}

	@JsonProperty("secondary_email")
	public void setSecondaryEmail(String value) {
		secondary_email = value;
	}

	public String getServiceCategory() {
		return service_category;
	}

	@JsonProperty("service_category")
	public void setServiceCategory(String value) {
		service_category = value;
	}

	public String getServiceDate() {
		return service_date;
	}

	@JsonProperty("service_date")
	public void setServiceDate(String value) {
		service_date = value;
	}


	public String getServiceDetail() {
		return service_detail;
	}

	@JsonProperty("service_detail")
	public void setServiceDetail(String value) {
		service_detail = value;
	}

	public String getServiceLocation() {
		return service_location;
	}

	@JsonProperty("service_location")
	public void setServiceLocation(String value) {
		service_location = value;
	}

	public int getTimeToService() {
		return time_to_service;
	}

	@JsonProperty("time_to_service")
	public void setTimeToService(int value) {
		time_to_service = value;
	}

	public String getDeliveryType() {
		return delivery_type;
	}

	@JsonProperty("delivery_type")
	public void setDeliveryType(String value) {
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

	public String getCardFirstSix() {
		return cardfirstsix;
	}

	@JsonProperty("cardfirstsix")
	public void setCardFirstSix(String value) {
		cardfirstsix = value;
	}

	public String getHashedCardNumber() {
		return hashedcardnumber;
	}

	@JsonProperty("hashedcardnumber")
	public void setHashedCardNumber(String value) {
		hashedcardnumber = value;
	}

	public String getCustom3() {
		return custom3;
	}

	@JsonProperty("custom3")
	public void setCustom3(String custom3) {
		this.custom3 = custom3;
	}

	public String getCustom4() {
		return custom4;
	}

	@JsonProperty("custom4")
	public void setCustom4(String custom4) {
		this.custom4 = custom4;
	}

	public String getCustom5() {
		return custom5;
	}

	@JsonProperty("custom5")
	public void setCustom5(String custom5) {
		this.custom5 = custom5;
	}

	public String getCustom6() {
		return custom6;
	}
	@JsonProperty("custom6")
	public void setCustom6(String custom6) {
		this.custom6 = custom6;
	}

	public String getCustom7() {
		return custom7;
	}
	@JsonProperty("custom7")
	public void setCustom7(String custom7) {
		this.custom7 = custom7;
	}

	public String getTrackingId() {
		return trackingId;
	}

	@JsonProperty("trackingId")
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}


	public String getPocPreProcessing() {
		return pocPreProcessing;
	}

	@JsonProperty("pocPreProcessing")
	public void setPocPreProcessing(String pocPreProcessing) {
		this.pocPreProcessing = pocPreProcessing;
	}

	public int getTransactionTypeId() {
		return transactionTypeId;
	}

	@JsonProperty("transactionTypeId")
	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getTransactionTypeDescription() {
		return transactionTypeDescription;
	}

	@JsonProperty("transactionTypeDescription")
	public void setTransactionTypeDescription(String transactionTypeDescription) {
		this.transactionTypeDescription = transactionTypeDescription;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}
	@JsonProperty("phoneCountryCode")
	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	public String getCcBinNumber() {
		return String.valueOf(ccBinNumber);
	}
	@JsonProperty("ccBinNumber")
	public void setCcBinNumber(int ccBinNumber) {
		this.ccBinNumber = ccBinNumber;
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
				}  else if (prop.getType().toString().equals("int")) {
					prop.setAccessible(true);
					int value = (int) prop.get(this);
					sb.append(String.format("&%s=%d", prop.getName(), value));
				}
			}
		} catch(Exception e){
			throw new EmailageParameterException("Could not parse extra input parameters for the request",e);
		}
		return sb.toString();
	}

}
