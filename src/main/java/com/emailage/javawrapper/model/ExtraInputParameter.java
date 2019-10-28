package com.emailage.javawrapper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtraInputParameter {

	private String firstName;
	private String lastName;
	private String billAddress;
	private String billCity;
	private String billRegion;
	private String billPostal;
	private String billCountry;
	private String shipAddress;
	private String shipCity;
	private String shipRegion;
	private String shipPostal;
	private String shipCountry;
	private String phone;
	private double transAmount;
	private String transCurrency;
	private String transOrigin;
	private boolean existingCustomer;
	private String userAgent;
	private String acceptLang;
	private String customerId;
	private String urId;
	private String deliveryType;
	private String deviceId;
	private String deviceSource;
	private String responseLanguage;
	private String userEmail;
	private String secondaryEmail;
	private String serviceCategory;
	private String serviceDate;
	private String serviceDetail;
	private String serviceLocation;
	private int timeToService;
	private String custom1;
	private String custom2;
	private String cardFirstSix;
	private String hashedCardNumber;


	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstname")
	public void setFirstName(String value) {
		firstName = value;
	}

	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastname")
	public void setLastName(String value) {
		lastName = value;
	}

	public String getBillAddress() {
		return billAddress;
	}

	@JsonProperty("billaddress")
	public void setBillAddress(String value) {
		billAddress = value;
	}

	public String getBillCity() {
		return billCity;
	}

	@JsonProperty("billcity")
	public void setBillCity(String value) {
		billCity = value;
	}

	public String getBillRegion() {
		return billRegion;
	}

	@JsonProperty("billregion")
	public void setBillRegion(String value) {
		billRegion = value;
	}

	public String getBillPostal() {
		return billPostal;
	}

	@JsonProperty("billpostal")
	public void setBillPostal(String value) {
		billPostal = value;
	}

	public String getBillCountry() {
		return billCountry;
	}

	@JsonProperty("billcountry")
	public void setBillCountry(String value) {
		billCountry = value;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	@JsonProperty("shipaddress")
	public void setShipAddress(String value) {
		shipAddress = value;
	}

	public String getShipCity() {
		return shipCity;
	}

	@JsonProperty("shipcity")
	public void setShipCity(String value) {
		shipCity = value;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	@JsonProperty("shipregion")
	public void setShipRegion(String value) {
		shipRegion = value;
	}

	public String getShipPostal() {
		return shipPostal;
	}

	@JsonProperty("shippostal")
	public void setShipPostal(String value) {
		shipPostal = value;
	}


	public String getShipCountry() {
		return shipCountry;
	}

	@JsonProperty("shipcountry")
	public void setShipCountry(String value) {
		shipCountry = value;
	}

	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String value) {
		phone = value;
	}

	public double getTransAmount() {
		return transAmount;
	}

	@JsonProperty("transamount")
	public void setTransAmount(double value) {
		transAmount = value;
	}

	public String getTransCurrency() {
		return transCurrency;
	}

	@JsonProperty("transcurrency")
	public void setTransCurrency(String value) {
		transCurrency = value;
	}

	public String getTransOrigin() {
		return transOrigin;
	}

	@JsonProperty("transorigin")
	public void setTransOrigin(String value) {
		transOrigin = value;
	}

	public boolean getExistingCustomer() {
		return existingCustomer;
	}

	@JsonProperty("existingcustomer")
	public void setExistingCustomer(boolean value) {
		existingCustomer = value;
	}

	public String getUserAgent() {
		return userAgent;
	}

	@JsonProperty("useragent")
	public void setUserAgent(String value) {
		userAgent = value;
	}

	public String getAcceptLang() {
		return acceptLang;
	}

	@JsonProperty("acceptlang")
	public void setAcceptLang(String value) {
		acceptLang = value;
	}

	public String getCustomerId() {
		return customerId;
	}

	@JsonProperty("customerid")
	public void setCustomerId(String value) {
		customerId = value;
	}

	public String getUrId() {
		return urId;
	}

	@JsonProperty("urid")
	public void setUrId(String value) {
		urId = value;
	}

	public String getDeviceId() {
		return deviceId;
	}

	@JsonProperty("deviceid")
	public void setDeviceId(String value) {
		deviceId = value;
	}

	public String getDeviceSource() {
		return deviceSource;
	}

	@JsonProperty("devicesource")
	public void setDeviceSource(String value) {
		deviceSource = value;
	}

	public String getResponseLanguage() {
		return responseLanguage;
	}

	@JsonProperty("response_language")
	public void setResponseLanguage(String value) {
		responseLanguage = value;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@JsonProperty("user_email")
	public void setUserEmail(String value) {
		userEmail = value;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	@JsonProperty("secondary_email")
	public void setSecondaryEmail(String value) {
		secondaryEmail = value;
	}

	public String getServiceCategory() {
		return serviceCategory;
	}

	@JsonProperty("service_category")
	public void setServiceCategory(String value) {
		serviceCategory = value;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	@JsonProperty("service_date")
	public void setServiceDate(String value) {
		serviceDate = value;
	}


	public String getServiceDetail() {
		return serviceDetail;
	}

	@JsonProperty("service_detail")
	public void setServiceDetail(String value) {
		serviceDetail = value;
	}

	public String getServiceLocation() {
		return serviceLocation;
	}

	@JsonProperty("service_location")
	public void setServiceLocation(String value) {
		serviceLocation = value;
	}

	public int getTimeToService() {
		return timeToService;
	}

	@JsonProperty("time_to_service")
	public void setTimeToService(int value) {
		timeToService = value;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	@JsonProperty("delivery_type")
	public void setDeliveryType(String value) {
		deliveryType = value;
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
		return cardFirstSix;
	}

	@JsonProperty("cardFirstSix")
	public void setCardFirstSix(String value) {
		cardFirstSix = value;
	}

	public String getHashedCardNumber() {
		return hashedCardNumber;
	}

	@JsonProperty("hashedCardNumber")
	public void setHashedCardNumber(String value) {
		hashedCardNumber = value;
	}

}
