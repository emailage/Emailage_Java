package com.emailage.javawrapper.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * All API output items are documented on the Emailage Portal site <a href="https://app.emailage.com/docs/index.html#api-EmailageValidator-QueryResponseFields">here.</a>
 */
public class EmailageQuery {
    private String email;
    private String ipaddress;
    private String queryType;
    private int count;
    private String created;
    private String lang;
    private long responseCount;
    private String responseLanguage;
    private List<EmailageResult> results;
    private String raw;
    private String flag;
    private String billCity;
    private String billpostal;
    private String transAmount;
    private String existingCustomer;
    private String fraudCodeID;

    private String acceptLang;
    private String billAddress;
    private String billRegion;
    private String billCountry;
    private String deviceId;
    private String deviceSource;
    private String firstName;
    private String lastName;
    private String phone;
    private String shipAddress;
    private String shipCity;
    private String shipcountry;
    private String shipPostal;
    private String shipRegion;
    private String transCurrency;
    private String transOrigin;
    private String urid;
    private String customerId;
    private String cardFirstSix;
    private String userEmail;
    private String userAgent;
    private String timeToService;
    private String secondaryEmail;
    private String serviceDate;
    private String serviceLocation;
    private String serviceDetail;
    private String serviceCategory;
    private String serviceType;
    private String hashedCardNumber;
    private String custom1;
    private String custom2;
    private String custom3;
    private String custom4;
    private String custom5;
    private String custom6;
    private String custom7;
    private String trackingId;
    private String pocPreProcessing;
    private int transactionTypeId;
    private String transactionTypeDescription;
    private String phoneCountryCode;
    private int ccBinNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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

    public String getLang() {
        return lang;
    }

    public long getResponseCount() {
        return responseCount;
    }

    public String getResponse_language() {
        return responseLanguage;
    }

    public List<EmailageResult> getResults() {
        return results;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setResponseCount(long responseCount) {
        this.responseCount = responseCount;
    }

    @JsonProperty("response_language")
    public void setResponse_language(String responseLanguage) {
        this.responseLanguage = responseLanguage;
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

    @JsonProperty("billcity")
    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    public String getBillpostal() {
        return billpostal;
    }

    @JsonProperty("billpostal")
    public void setBillpostal(String billpostal) {
        this.billpostal = billpostal;
    }

    public String getTransAmount() {
        return transAmount;
    }

    @JsonProperty("transamount")
    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getExistingCustomer() {
        return existingCustomer;
    }

    @JsonProperty("existingcustomer")
    public void setExistingCustomer(String existingCustomer) {
        this.existingCustomer = existingCustomer;
    }

    public String getFraudCodeID() {
        return fraudCodeID;
    }

    @JsonProperty("fraudcodeID")
    public void setFraudCodeID(String fraudCodeID) {
        this.fraudCodeID = fraudCodeID;
    }

    public String getAcceptLang() {
        return acceptLang;
    }

    @JsonProperty("acceptlang")
    public void setAcceptLang(String acceptLang) {
        this.acceptLang = acceptLang;
    }

    public String getBillAddress() {
        return billAddress;
    }

    @JsonProperty("billaddress")
    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public String getBillRegion() {
        return billRegion;
    }

    @JsonProperty("billregion")
    public void setBillRegion(String billRegion) {
        this.billRegion = billRegion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("deviceid")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSource() {
        return deviceSource;
    }

    @JsonProperty("devicesource")
    public void setDeviceSource(String deviceSource) {
        this.deviceSource = deviceSource;
    }

    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstname")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastname")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    @JsonProperty("shipaddress")
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    @JsonProperty("shipcity")
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipcountry() {
        return shipcountry;
    }

    @JsonProperty("shipcountry")
    public void setShipcountry(String shipcountry) {
        this.shipcountry = shipcountry;
    }

    public String getShipPostal() {
        return shipPostal;
    }

    @JsonProperty("shippostal")
    public void setShipPostal(String shipPostal) {
        this.shipPostal = shipPostal;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    @JsonProperty("shipregion")
    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getTransCurrency() {
        return transCurrency;
    }

    @JsonProperty("transcurrency")
    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public String getTransOrigin() {
        return transOrigin;
    }

    @JsonProperty("transorigin")
    public void setTransOrigin(String transOrigin) {
        this.transOrigin = transOrigin;
    }

    public String getUrid() {
        return urid;
    }

    @JsonProperty("urid")
    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("customerid")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardFirstSix() {
        return cardFirstSix;
    }

    @JsonProperty("cardFirstSix")
    public void setCardFirstSix(String cardFirstSix) {
        this.cardFirstSix = cardFirstSix;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty("user_email")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAgent() {
        return userAgent;
    }

    @JsonProperty("useragent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getTimeToService() {
        return timeToService;
    }

    @JsonProperty("time_to_service")
    public void setTimeToService(String timeToService) {
        this.timeToService = timeToService;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    @JsonProperty("secondary_email")
    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    @JsonProperty("service_date")
    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    @JsonProperty("service_location")
    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    @JsonProperty("service_detail")
    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    @JsonProperty("service_category")
    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("service_type")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getHashedCardNumber() {
        return hashedCardNumber;
    }

    @JsonProperty("hashedCardNumber")
    public void setHashedCardNumber(String hashedCardNumber) {
        this.hashedCardNumber = hashedCardNumber;
    }

    public String getCustom1() {
        return custom1;
    }

    @JsonProperty("custom1")
    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    @JsonProperty("custom2")
    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getBillCountry() {
        return billCountry;
    }

    @JsonProperty("billcountry")
    public void setBillCountry(String billCountry) {
        this.billCountry = billCountry;
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

    public String getPhoneCountryCode()  {  return phoneCountryCode; }
    @JsonProperty("phoneCountryCode")
    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public int getCcBinNumber() {  return ccBinNumber; }
    @JsonProperty("ccBinNumber")
    public void setCcBinNumber(int ccBinNumber ) {
        this.ccBinNumber = ccBinNumber;
    }


}
