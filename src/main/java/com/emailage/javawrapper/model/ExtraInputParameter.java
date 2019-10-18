package com.emailage.javawrapper.model;

import com.emailage.javawrapper.model.exception.EmailageParameterException;
import com.emailage.javawrapper.utilities.ParameterRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class ExtraInputParameter {
	@JsonProperty("firstname")
	@ParameterRequest(name = "firstname")
	private String firstName = StringUtils.EMPTY;

	@JsonProperty("lastname")
	@ParameterRequest(name = "lastname")
	private String lastName = StringUtils.EMPTY;

	@JsonProperty("billaddress")
	@ParameterRequest(name = "billaddress")
	private String billAddress = StringUtils.EMPTY;

	@JsonProperty("billcity")
	@ParameterRequest(name = "billcity")
	private String billCity = StringUtils.EMPTY;

	@JsonProperty("billregion")
	@ParameterRequest(name = "billregion")
	private String billRegion = StringUtils.EMPTY;

	@JsonProperty("billpostal")
	@ParameterRequest(name = "billpostal")
	private String billPostal = StringUtils.EMPTY;

	@JsonProperty("billcountry")
	@ParameterRequest(name = "billcountry")
	private String billCountry = StringUtils.EMPTY;

	@JsonProperty("shipaddress")
	@ParameterRequest(name = "shipaddress")
	private String shipAddress = StringUtils.EMPTY;

	@JsonProperty("shipcity")
	@ParameterRequest(name = "shipcity")
	private String shipCity = StringUtils.EMPTY;

	@JsonProperty("shipregion")
	@ParameterRequest(name = "shipregion")
	private String shipRegion = StringUtils.EMPTY;

	@JsonProperty("shippostal")
	@ParameterRequest(name = "shippostal")
	private String shipPostal = StringUtils.EMPTY;

	@JsonProperty("shipcountry")
	@ParameterRequest(name = "shipcountry")
	private String shipCountry = StringUtils.EMPTY;

	@JsonProperty("phone")
	@ParameterRequest(name = "phone")
	private String phone = StringUtils.EMPTY;

	@JsonProperty("transamount")
	@ParameterRequest(name = "transamount")
	private double transAmount;

	@JsonProperty("transcurrency")
	@ParameterRequest(name = "transcurrency")
	private String transCurrency = StringUtils.EMPTY;

	@JsonProperty("transorigin")
	@ParameterRequest(name = "transorigin")
	private String transOrigin = StringUtils.EMPTY;

	@JsonProperty("existingcustomer")
	@ParameterRequest(name = "existingcustomer")
	private boolean existingCustomer;

	@JsonProperty("useragent")
	@ParameterRequest(name = "useragent")
	private String userAgent = StringUtils.EMPTY;

	@JsonProperty("acceptlang")
	@ParameterRequest(name = "acceptlang")
	private String acceptLang = StringUtils.EMPTY;

	@JsonProperty("customerid")
	@ParameterRequest(name = "customerid")
	private String customerId = StringUtils.EMPTY;

	@JsonProperty("urid")
	@ParameterRequest(name = "urid")
	private String urid = StringUtils.EMPTY;

	@JsonProperty("deviceid")
	@ParameterRequest(name = "deviceid")
	private String deviceId = StringUtils.EMPTY;

	@JsonProperty("devicesource")
	@ParameterRequest(name = "devicesource")
	private String deviceSource = StringUtils.EMPTY;

	@JsonProperty("response_language")
	@ParameterRequest(name = "response_language")
	private String responseLanguage = StringUtils.EMPTY;

	@JsonProperty("user_email")
	@ParameterRequest(name = "user_email")
	private String userEmail = StringUtils.EMPTY;

	@JsonProperty("secondary_email")
	@ParameterRequest(name = "secondary_email")
	private String secondaryEmail = StringUtils.EMPTY;

	@JsonProperty("service_category")
	@ParameterRequest(name = "service_category")
	private String serviceCategory = StringUtils.EMPTY;

	@JsonProperty("service_date")
	@ParameterRequest(name = "service_date")
	private String serviceDate = StringUtils.EMPTY;

	@JsonProperty("service_detail")
	@ParameterRequest(name = "service_detail")
	private String serviceDetail = StringUtils.EMPTY;

	@JsonProperty("service_location")
	@ParameterRequest(name = "service_location")
	private String serviceLocation = StringUtils.EMPTY;

	@JsonProperty("time_to_service")
	private int timeToService;

	@JsonProperty("delivery_type")
	@ParameterRequest(name = "delivery_type")
	private String deliveryType = StringUtils.EMPTY;

	@JsonProperty("custom1")
	@ParameterRequest(name = "custom1")
	private String custom1 = StringUtils.EMPTY;

	@JsonProperty("custom2")
	@ParameterRequest(name = "custom2")
	private String custom2 = StringUtils.EMPTY;

	@JsonProperty("cardFirstSix")
	@ParameterRequest(name = "cardFirstSix")
	private String cardFirstSix = StringUtils.EMPTY;

	@JsonProperty("hashedCardNumber")
	@ParameterRequest(name = "hashedCardNumber")
	private String hashedCardNumber = StringUtils.EMPTY;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBillAddress() {
		return billAddress;
	}

	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}

	public String getBillCity() {
		return billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	public String getBillRegion() {
		return billRegion;
	}

	public void setBillRegion(String billRegion) {
		this.billRegion = billRegion;
	}

	public String getBillPostal() {
		return billPostal;
	}

	public void setBillPostal(String billPostal) {
		this.billPostal = billPostal;
	}

	public String getBillCountry() {
		return billCountry;
	}

	public void setBillCountry(String billCountry) {
		this.billCountry = billCountry;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public String getShipPostal() {
		return shipPostal;
	}

	public void setShipPostal(String shipPostal) {
		this.shipPostal = shipPostal;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

	public String getTransOrigin() {
		return transOrigin;
	}

	public void setTransOrigin(String transOrigin) {
		this.transOrigin = transOrigin;
	}

	public boolean isExistingCustomer() {
		return existingCustomer;
	}

	public void setExistingCustomer(boolean existingCustomer) {
		this.existingCustomer = existingCustomer;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getAcceptLang() {
		return acceptLang;
	}

	public void setAcceptLang(String acceptLang) {
		this.acceptLang = acceptLang;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUrid() {
		return urid;
	}

	public void setUrid(String urid) {
		this.urid = urid;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceSource() {
		return deviceSource;
	}

	public void setDeviceSource(String deviceSource) {
		this.deviceSource = deviceSource;
	}

	public String getResponseLanguage() {
		return responseLanguage;
	}

	public void setResponseLanguage(String responseLanguage) {
		this.responseLanguage = responseLanguage;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getServiceDetail() {
		return serviceDetail;
	}

	public void setServiceDetail(String serviceDetail) {
		this.serviceDetail = serviceDetail;
	}

	public String getServiceLocation() {
		return serviceLocation;
	}

	public void setServiceLocation(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}

	public int getTimeToService() {
		return timeToService;
	}

	public void setTimeToService(int timeToService) {
		this.timeToService = timeToService;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getCustom1() {
		return custom1;
	}

	public void setCustom1(String custom1) {
		this.custom1 = custom1;
	}

	public String getCustom2() {
		return custom2;
	}

	public void setCustom2(String custom2) {
		this.custom2 = custom2;
	}

	public String getCardFirstSix() {
		return cardFirstSix;
	}

	public void setCardFirstSix(String cardFirstSix) {
		this.cardFirstSix = cardFirstSix;
	}

	public String getHashedCardNumber() {
		return hashedCardNumber;
	}

	public void setHashedCardNumber(String hashedCardNumber) {
		this.hashedCardNumber = hashedCardNumber;
	}



	public String buildExtraInputParameterRequest()
			throws EmailageParameterException {
		StringBuilder sb = new StringBuilder();
		try {
			Class clazz = this.getClass();
			for (Field field : clazz.getDeclaredFields()) {
				String name;
				if (field.isAnnotationPresent(ParameterRequest.class)) {
					ParameterRequest parameterRequest = field.getAnnotation(ParameterRequest.class);
					name = parameterRequest.name();
					if (name.equals("time_to_service"))
						System.out.printf("");
					sb.append(String.format("&%s=%s", name, field.get(this).toString()));
				}
			}
			return sb.toString();
		} catch(Exception e){
			throw new EmailageParameterException("Could not parse extra input parameters for the request",e);
		}
	}

}
