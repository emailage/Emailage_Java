package com.emailage.javawrapper.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmailageResult {

    private String userDefinedRecordID;
    private String email;
    private String ipAddress;
    private String eName;
    private String emailAge;
    private String emailCreationDays;
    private String domainAge;
    private String domainCreationDays;
    private String firstVerificationDate;
    private String firstSeenDays;
    private String lastVerificationDate;
    private String Status;
    private String Country;
    private String fraudRisk;
    private String EAScore;
    private String EAReason;
    private String EAStatusID;
    private String EAReasonID;
    private String EAAdviceID;
    private String EAAdvice;
    private String EARiskBandID;
    private String EARiskBand;
    private String sourceIndustry;
    private String fraudType;
    private String lastFlaggedOn;
    private String dob;
    private String gender;
    private String location;
    private String smFriends;
    private String totalHits;
    private String uniqueHits;
    private String imageURL;
    private String emailExists;
    private String domainExists;
    private String company;
    private String title;
    private String domainName;
    private String domainCompany;
    private String domainCountryName;
    private String domainCategory;
    private String domainCorporate;
    private String domainRiskLevel;
    private String domainRelevantInfo;
    private String domainRiskLevelID;
    private String domainRelevantInfoID;
    private String domainRiskCountry;
    private List<EmailageSMLinks> socialMediaLinks;
    private String ipRiskLevelID;
    private String ipRiskLevel;
    private String ipRiskReasonID;
    private String ipRiskReason;
    private String ipReputation;
    private String ipAnonymousDetected;
    private String ipProxyType;
    private String ipProxyDescription;
    private String ipISP;
    private String ipOrg;
    private String ipUserType;
    private String ipNetSpeedCell;
    private String ipCorporateProxy;
    private String ipContinentCode;
    private String ipCountry;
    private String ipCountryCode;
    private String ipRegion;
    private String ipCity;
    private String ipCallingCode;
    private String ipMetroCode;
    private String ipLatitude;
    private String ipLongitude;
    private String ipMap;
    private String ipCountryMatch;
    private String ipDistanceKm;
    private String ipDistanceMil;
    private String ipAccuracyRadius;
    private String ipTimezone;
    private String ipAsNum;
    private String ipDomain;
    private String ipCountryConf;
    private String ipRegionConf;
    private String ipCityconf;
    private String ipPostalCode;
    private String ipPostalConf;
    private String ipRiskScore;
    private String custPhoneInBillingLoc;
    private String cityPostalMatch;
    private String shipCityPostalMatch;
    private String phoneStatus;
    private String shipForward;

    public String getUserDefinedRecordID() {
        return userDefinedRecordID;
    }

    @JsonProperty(value = "userdefinedrecordid")
    public void setUserDefinedRecordID(String userDefinedRecordID) {
        this.userDefinedRecordID = userDefinedRecordID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("ipaddress")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getEmailAge() {
        return emailAge;
    }

    public void setEmailAge(String emailAge) {
        this.emailAge = emailAge;
    }

    public String getEmailCreationDays() {
        return emailCreationDays;
    }

    @JsonProperty(value = "email_creation_days")
    public void setEmailCreationDays(String emailCreationDays) {
        this.emailCreationDays = emailCreationDays;
    }

    public String getDomainAge() {
        return domainAge;
    }

    public void setDomainAge(String domainAge) {
        this.domainAge = domainAge;
    }

    public String getDomainCreationDays() {
        return domainCreationDays;
    }

    @JsonProperty(value = "domain_creation_days")
    public void setDomainCreationDays(String domainCreationDays) {
        this.domainCreationDays = domainCreationDays;
    }

    public String getFirstVerificationDate() {
        return firstVerificationDate;
    }

    public void setFirstVerificationDate(String firstVerificationDate) {
        this.firstVerificationDate = firstVerificationDate;
    }

    public String getFirstSeenDays() {
        return firstSeenDays;
    }

    @JsonProperty(value ="first_seen_days")
    public void setFirstSeenDays(String firstSeenDays) {
        this.firstSeenDays = firstSeenDays;
    }

    public String getLastVerificationDate() {
        return lastVerificationDate;
    }

    public void setLastVerificationDate(String lastVerificationDate) {
        this.lastVerificationDate = lastVerificationDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getFraudRisk() {
        return fraudRisk;
    }

    public void setFraudRisk(String fraudRisk) {
        this.fraudRisk = fraudRisk;
    }

    public String getEAScore() {
        return EAScore;
    }

    @JsonProperty("EAScore")
    public void setEAScore(String EAScore) {
        this.EAScore = EAScore;
    }

    public String getEAReason() {
        return EAReason;
    }

    @JsonProperty("EAReason")
    public void setEAReason(String EAReason) {
        this.EAReason = EAReason;
    }

    public String getEAStatusID() {
        return EAStatusID;
    }

    @JsonProperty("EAStatusID")
    public void setEAStatusID(String EAStatusID) {
        this.EAStatusID = EAStatusID;
    }

    public String getEAReasonID() {
        return EAReasonID;
    }

    @JsonProperty("EAReasonID")
    public void setEAReasonID(String EAReasonID) {
        this.EAReasonID = EAReasonID;
    }

    public String getEAAdviceID() {
        return EAAdviceID;
    }

    @JsonProperty("EAAdviceID")
    public void setEAAdviceID(String EAAdviceID) {
        this.EAAdviceID = EAAdviceID;
    }

    public String getEAAdvice() {
        return EAAdvice;
    }

    @JsonProperty("EAAdvice")
    public void setEAAdvice(String EAAdvice) {
        this.EAAdvice = EAAdvice;
    }

    public String getEARiskBandID() {
        return EARiskBandID;
    }

    @JsonProperty("EARiskBandID")
    public void setEARiskBandID(String EARiskBandID) {
        this.EARiskBandID = EARiskBandID;
    }

    public String getEARiskBand() {
        return EARiskBand;
    }

    @JsonProperty("EARiskBand")
    public void setEARiskBand(String EARiskBand) {
        this.EARiskBand = EARiskBand;
    }

    public String getSourceIndustry() {
        return sourceIndustry;
    }

    @JsonProperty("source_industry")
    public void setSourceIndustry(String sourceIndustry) {
        this.sourceIndustry = sourceIndustry;
    }

    public String getFraudType() {
        return fraudType;
    }

    @JsonProperty("fraud_type")
    public void setFraudType(String fraudType) {
        this.fraudType = fraudType;
    }

    public String getLastFlaggedOn() {
        return lastFlaggedOn;
    }

    @JsonProperty("lastflaggedon")
    public void setLastFlaggedOn(String lastFlaggedOn) {
        this.lastFlaggedOn = lastFlaggedOn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSmFriends() {
        return smFriends;
    }

    @JsonProperty("smfriends")
    public void setSmFriends(String smFriends) {
        this.smFriends = smFriends;
    }

    public String getTotalHits() {
        return totalHits;
    }

    @JsonProperty("totalhits")
    public void setTotalHits(String totalHits) {
        this.totalHits = totalHits;
    }

    public String getUniqueHits() {
        return uniqueHits;
    }

    @JsonProperty("uniquehits")
    public void setUniqueHits(String uniqueHits) {
        this.uniqueHits = uniqueHits;
    }

    public String getImageURL() {
        return imageURL;
    }

    @JsonProperty("imageurl")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEmailExists() {
        return emailExists;
    }

    public void setEmailExists(String emailExists) {
        this.emailExists = emailExists;
    }

    public String getDomainExists() {
        return domainExists;
    }

    public void setDomainExists(String domainExists) {
        this.domainExists = domainExists;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDomainName() {
        return domainName;
    }

    @JsonProperty("domainname")
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainCompany() {
        return domainCompany;
    }

    @JsonProperty("domaincompany")
    public void setDomainCompany(String domainCompany) {
        this.domainCompany = domainCompany;
    }

    public String getDomainCountryName() {
        return domainCountryName;
    }

    @JsonProperty("domaincountryname")
    public void setDomainCountryName(String domainCountryName) {
        this.domainCountryName = domainCountryName;
    }

    public String getDomainCategory() {
        return domainCategory;
    }

    @JsonProperty("domaincategory")
    public void setDomainCategory(String domainCategory) {
        this.domainCategory = domainCategory;
    }

    public String getDomainCorporate() {
        return domainCorporate;
    }

    @JsonProperty("domaincorporate")
    public void setDomainCorporate(String domainCorporate) {
        this.domainCorporate = domainCorporate;
    }

    public String getDomainRiskLevel() {
        return domainRiskLevel;
    }

    @JsonProperty("domainrisklevel")
    public void setDomainRiskLevel(String domainRiskLevel) {
        this.domainRiskLevel = domainRiskLevel;
    }

    public String getDomainRelevantInfo() {
        return domainRelevantInfo;
    }

    @JsonProperty("domainrelevantinfo")
    public void setDomainRelevantInfo(String domainRelevantInfo) {
        this.domainRelevantInfo = domainRelevantInfo;
    }

    public String getDomainRiskLevelID() {
        return domainRiskLevelID;
    }

    @JsonProperty("domainrisklevelID")
    public void setDomainRiskLevelID(String domainRiskLevelID) {
        this.domainRiskLevelID = domainRiskLevelID;
    }

    public String getDomainRelevantInfoID() {
        return domainRelevantInfoID;
    }

    @JsonProperty("domainrelevantinfoID")
    public void setDomainRelevantInfoID(String domainRelevantInfoID) {
        this.domainRelevantInfoID = domainRelevantInfoID;
    }

    public String getDomainRiskCountry() {
        return domainRiskCountry;
    }

    @JsonProperty("domainriskcountry")
    public void setDomainRiskCountry(String domainRiskCountry) {
        this.domainRiskCountry = domainRiskCountry;
    }

    public List<EmailageSMLinks> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    @JsonProperty("smlinks")
    public void setSocialMediaLinks(List<EmailageSMLinks> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public String getIpRiskLevelID() {
        return ipRiskLevelID;
    }

    @JsonProperty("ip_risklevelid")
    public void setIpRiskLevelID(String ipRiskLevelID) {
        this.ipRiskLevelID = ipRiskLevelID;
    }

    public String getIpRiskLevel() {
        return ipRiskLevel;
    }

    @JsonProperty("ip_risklevel")
    public void setIpRiskLevel(String ipRiskLevel) {
        this.ipRiskLevel = ipRiskLevel;
    }

    public String getIpRiskReasonID() {
        return ipRiskReasonID;
    }

    @JsonProperty("ip_riskreasonid")
    public void setIpRiskReasonID(String ipRiskReasonID) {
        this.ipRiskReasonID = ipRiskReasonID;
    }

    public String getIpRiskReason() {
        return ipRiskReason;
    }

    @JsonProperty("ip_riskreason")
    public void setIpRiskReason(String ipRiskReason) {
        this.ipRiskReason = ipRiskReason;
    }

    public String getIpReputation() {
        return ipReputation;
    }

    @JsonProperty("ip_reputation")
    public void setIpReputation(String ipReputation) {
        this.ipReputation = ipReputation;
    }

    public String getIpAnonymousDetected() {
        return ipAnonymousDetected;
    }

    @JsonProperty("ip_anonymousdetected")
    public void setIpAnonymousDetected(String ipAnonymousDetected) {
        this.ipAnonymousDetected = ipAnonymousDetected;
    }

    public String getIpProxyType() {
        return ipProxyType;
    }

    @JsonProperty("ip_proxytype")
    public void setIpProxyType(String ipProxyType) {
        this.ipProxyType = ipProxyType;
    }

    public String getIpProxyDescription() {
        return ipProxyDescription;
    }

    @JsonProperty("ip_proxydescription")
    public void setIpProxyDescription(String ipProxyDescription) {
        this.ipProxyDescription = ipProxyDescription;
    }

    public String getIpISP() {
        return ipISP;
    }

    @JsonProperty("ip_isp")
    public void setIpISP(String ipISP) {
        this.ipISP = ipISP;
    }

    public String getIpOrg() {
        return ipOrg;
    }

    @JsonProperty("ip_org")
    public void setIpOrg(String ipOrg) {
        this.ipOrg = ipOrg;
    }

    public String getIpUserType() {
        return ipUserType;
    }

    @JsonProperty("ip_userType")
    public void setIpUserType(String ipUserType) {
        this.ipUserType = ipUserType;
    }

    public String getIpNetSpeedCell() {
        return ipNetSpeedCell;
    }

    @JsonProperty("ip_netSpeedCell")
    public void setIpNetSpeedCell(String ipNetSpeedCell) {
        this.ipNetSpeedCell = ipNetSpeedCell;
    }

    public String getIpCorporateProxy() {
        return ipCorporateProxy;
    }

    @JsonProperty("ip_coporateProxy")
    public void setIpCorporateProxy(String ipCorporateProxy) {
        this.ipCorporateProxy = ipCorporateProxy;
    }

    public String getIpContinentCode() {
        return ipContinentCode;
    }

    @JsonProperty("ip_continentCode")
    public void setIpContinentCode(String ipContinentCode) {
        this.ipContinentCode = ipContinentCode;
    }

    public String getIpCountry() {
        return ipCountry;
    }

    @JsonProperty("ip_country")
    public void setIpCountry(String ipCountry) {
        this.ipCountry = ipCountry;
    }

    public String getIpCountryCode() {
        return ipCountryCode;
    }

    @JsonProperty("ip_countryCode")
    public void setIpCountryCode(String ipCountryCode) {
        this.ipCountryCode = ipCountryCode;
    }

    public String getIpRegion() {
        return ipRegion;
    }

    @JsonProperty("ip_region")
    public void setIpRegion(String ipRegion) {
        this.ipRegion = ipRegion;
    }

    public String getIpCity() {
        return ipCity;
    }

    @JsonProperty("ip_city")
    public void setIpCity(String ipCity) {
        this.ipCity = ipCity;
    }

    public String getIpCallingCode() {
        return ipCallingCode;
    }

    @JsonProperty("ip_callingcode")
    public void setIpCallingCode(String ipCallingCode) {
        this.ipCallingCode = ipCallingCode;
    }

    public String getIpMetroCode() {
        return ipMetroCode;
    }

    @JsonProperty("ip_metroCode")
    public void setIpMetroCode(String ipMetroCode) {
        this.ipMetroCode = ipMetroCode;
    }

    public String getIpLatitude() {
        return ipLatitude;
    }

    @JsonProperty("ip_latitude")
    public void setIpLatitude(String ipLatitude) {
        this.ipLatitude = ipLatitude;
    }

    public String getIpLongitude() {
        return ipLongitude;
    }

    @JsonProperty("ip_longitude")
    public void setIpLongitude(String ipLongitude) {
        this.ipLongitude = ipLongitude;
    }

    public String getIpMap() {
        return ipMap;
    }

    @JsonProperty("ip_map")
    public void setIpMap(String ipMap) {
        this.ipMap = ipMap;
    }

    public String getIpCountryMatch() {
        return ipCountryMatch;
    }

    @JsonProperty("ipcountrymatch")
    public void setIpCountryMatch(String ipCountryMatch) {
        this.ipCountryMatch = ipCountryMatch;
    }

    public String getIpDistanceKm() {
        return ipDistanceKm;
    }

    @JsonProperty("ipdistancekm")
    public void setIpDistanceKm(String ipDistanceKm) {
        this.ipDistanceKm = ipDistanceKm;
    }

    public String getIpDistanceMil() {
        return ipDistanceMil;
    }

    @JsonProperty("ipdistancemil")
    public void setIpDistanceMil(String ipDistanceMil) {
        this.ipDistanceMil = ipDistanceMil;
    }

    public String getIpAccuracyRadius() {
        return ipAccuracyRadius;
    }

    @JsonProperty("ipaccuracyradius")
    public void setIpAccuracyRadius(String ipAccuracyRadius) {
        this.ipAccuracyRadius = ipAccuracyRadius;
    }

    public String getIpTimezone() {
        return ipTimezone;
    }

    @JsonProperty("iptimezone")
    public void setIpTimezone(String ipTimezone) {
        this.ipTimezone = ipTimezone;
    }

    public String getIpAsNum() {
        return ipAsNum;
    }

    @JsonProperty("ipasnum")
    public void setIpAsNum(String ipAsNum) {
        this.ipAsNum = ipAsNum;
    }

    public String getIpDomain() {
        return ipDomain;
    }

    @JsonProperty("ipdomain")
    public void setIpDomain(String ipDomain) {
        this.ipDomain = ipDomain;
    }

    public String getIpCountryConf() {
        return ipCountryConf;
    }

    @JsonProperty("ip_countryconf")
    public void setIpCountryConf(String ipCountryConf) {
        this.ipCountryConf = ipCountryConf;
    }

    public String getIpRegionConf() {
        return ipRegionConf;
    }

    @JsonProperty("ip_regionconf")
    public void setIpRegionConf(String ipRegionConf) {
        this.ipRegionConf = ipRegionConf;
    }

    public String getIpCityconf() {
        return ipCityconf;
    }

    @JsonProperty("ip_cityconf")
    public void setIpCityconf(String ipCityconf) {
        this.ipCityconf = ipCityconf;
    }

    public String getIpPostalCode() {
        return ipPostalCode;
    }

    @JsonProperty("ip_postalcode")
    public void setIpPostalCode(String ipPostalCode) {
        this.ipPostalCode = ipPostalCode;
    }

    public String getIpPostalConf() {
        return ipPostalConf;
    }

    @JsonProperty("ip_postalconf")
    public void setIpPostalConf(String ipPostalConf) {
        this.ipPostalConf = ipPostalConf;
    }

    public String getIpRiskScore() {
        return ipRiskScore;
    }

    @JsonProperty("ip_riskscore")
    public void setIpRiskScore(String ipRiskScore) {
        this.ipRiskScore = ipRiskScore;
    }

    public String getCustPhoneInBillingLoc() {
        return custPhoneInBillingLoc;
    }

    @JsonProperty("custphoneInbillingloc")
    public void setCustPhoneInBillingLoc(String custPhoneInBillingLoc) {
        this.custPhoneInBillingLoc = custPhoneInBillingLoc;
    }

    public String getCityPostalMatch() {
        return cityPostalMatch;
    }

    @JsonProperty("citypostalmatch")
    public void setCityPostalMatch(String cityPostalMatch) {
        this.cityPostalMatch = cityPostalMatch;
    }

    public String getShipCityPostalMatch() {
        return shipCityPostalMatch;
    }

    @JsonProperty("shipcitypostalmatch")
    public void setShipCityPostalMatch(String shipCityPostalMatch) {
        this.shipCityPostalMatch = shipCityPostalMatch;
    }

    public String getPhoneStatus() {
        return phoneStatus;
    }

    @JsonProperty("phone_status")
    public void setPhoneStatus(String phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    public String getShipForward() {
        return shipForward;
    }

    @JsonProperty("shipforward")
    public void setShipForward(String shipForward) {
        this.shipForward = shipForward;
    }
}