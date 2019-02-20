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
    private String responseLanguage;
    private List<EmailageResult> results;
    private String raw;

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
}
