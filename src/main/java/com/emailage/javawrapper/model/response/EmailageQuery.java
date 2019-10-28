package com.emailage.javawrapper.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private List<EmailageResult> results;
    private String raw;
    private String flag;
    private String fraudCodeID;
    private String serviceType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpAddress() {
        return ipaddress;
    }

    @JsonProperty("ipaddress")
    public void setIpAddress(String ipaddress) {
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

    public String getFraudCodeID() {
        return fraudCodeID;
    }

    @JsonProperty("fraudcodeID")
    public void setFraudCodeId(String fraudCodeID) {
        this.fraudCodeID = fraudCodeID;
    }


    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("service_type")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

}
