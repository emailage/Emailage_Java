package com.emailage.javawrapper.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * All API output items are documented on the Emailage Portal site <a href="https://app.emailage.com/docs/index.html#api-EmailageValidator-QueryResponseFields">here.</a>
 */
public class EmailageQuery {

    @JsonProperty("email")
    private String email;

    @JsonProperty("ipaddress")
    private String ipAddress;

    @JsonProperty("queryType")
    private String queryType;

    @JsonProperty("count")
    private int count;

    @JsonProperty("created")
    private String created;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("responseCount")
    private long responseCount;

    @JsonProperty("response_language")
    private String responseLanguage;

    @JsonProperty("results")
    private List<EmailageResult> results;

    @JsonProperty("raw")
    private String raw;

    @JsonProperty("flag")
    private String flag;

    @JsonProperty("billcity")
    private String billCity;

    @JsonProperty("billpostal")
    private String billPostal;

    @JsonProperty("transamount")
    private String transAmount;

    @JsonProperty("existingcustomer")
    private String existingCustomer;

    @JsonProperty("fraudcodeID")
    private String fraudCodeId;

    @JsonProperty("acceptlang")
    private String acceptLang;

    @JsonProperty("billaddress")
    private String billAddress;

    @JsonProperty("billregion")
    private String billRegion;

    @JsonProperty("billcountry")
    private String billCountry;

    @JsonProperty("deviceid")
    private String deviceId;

    @JsonProperty("devicesource")
    private String deviceSource;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("shipaddress")
    private String shipAddress;

    @JsonProperty("shipcity")
    private String shipCity;

    @JsonProperty("shipcountry")
    private String shipCountry;

    @JsonProperty("shippostal")
    private String shipPostal;

    @JsonProperty("shipregion")
    private String shipRegion;

    @JsonProperty("transcurrency")
    private String transCurrency;

    @JsonProperty("transorigin")
    private String transOrigin;

    @JsonProperty("urid")
    private String urid;

    @JsonProperty("customerid")
    private String customerId;

    @JsonProperty("cardFirstSix")
    private String cardFirstSix;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("useragent")
    private String userAgent;

    @JsonProperty("time_to_service")
    private String timeToService;

    @JsonProperty("secondary_email")
    private String secondaryEmail;

    @JsonProperty("service_date")
    private String serviceDate;

    @JsonProperty("service_location")
    private String serviceLocation;

    @JsonProperty("service_detail")
    private String serviceDetail;

    @JsonProperty("service_category")
    private String serviceCategory;

    @JsonProperty("service_type")
    private String serviceType;

    @JsonProperty("hashedCardNumber")
    private String hashedCardNumber;

    @JsonProperty("custom1")
    private String custom1;

    @JsonProperty("custom2")
    private String custom2;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpaddress() {
        return ipAddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipAddress = ipaddress;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getResponseCount() {
        return responseCount;
    }

    public void setResponseCount(long responseCount) {
        this.responseCount = responseCount;
    }

    public String getResponseLanguage() {
        return responseLanguage;
    }

    public void setResponseLanguage(String responseLanguage) {
        this.responseLanguage = responseLanguage;
    }

    public List<EmailageResult> getResults() {
        return results;
    }

    public void setResults(List<EmailageResult> results) {
        this.results = results;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBillCity() {
        return billCity;
    }

    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    public String getBillPostal() {
        return billPostal;
    }

    public void setBillPostal(String billPostal) {
        this.billPostal = billPostal;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getExistingCustomer() {
        return existingCustomer;
    }

    public void setExistingCustomer(String existingCustomer) {
        this.existingCustomer = existingCustomer;
    }

    public String getFraudCodeId() {
        return fraudCodeId;
    }

    public void setFraudCodeId(String fraudCodeId) {
        this.fraudCodeId = fraudCodeId;
    }

    public String getAcceptLang() {
        return acceptLang;
    }

    public void setAcceptLang(String acceptLang) {
        this.acceptLang = acceptLang;
    }

    public String getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public String getBillRegion() {
        return billRegion;
    }

    public void setBillRegion(String billRegion) {
        this.billRegion = billRegion;
    }

    public String getBillCountry() {
        return billCountry;
    }

    public void setBillCountry(String billCountry) {
        this.billCountry = billCountry;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getShipPostal() {
        return shipPostal;
    }

    public void setShipPostal(String shipPostal) {
        this.shipPostal = shipPostal;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
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

    public String getUrid() {
        return urid;
    }

    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardFirstSix() {
        return cardFirstSix;
    }

    public void setCardFirstSix(String cardFirstSix) {
        this.cardFirstSix = cardFirstSix;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getTimeToService() {
        return timeToService;
    }

    public void setTimeToService(String timeToService) {
        this.timeToService = timeToService;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getHashedCardNumber() {
        return hashedCardNumber;
    }

    public void setHashedCardNumber(String hashedCardNumber) {
        this.hashedCardNumber = hashedCardNumber;
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
}
