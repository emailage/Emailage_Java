package com.emailage.javawrapper.model;

public class ConfigurationParameters {


    private String accountSecret;
    private String acccountToken;
    private String userEmail;
    private Enums.Environment environment;
    private Enums.SignatureMethod hashAlgorithm;
    private Enums.Format resultFormat;
    private boolean validateBeforeSending = true;
    private Enums.AuthenticationType authenticationType;

    public ConfigurationParameters(){
        this.authenticationType = Enums.AuthenticationType.OAUTH1;
    }

    /** @return Account Secret found in the Settings menu - API Key area on the portal. */
    public String getAccountSecret() {
        return accountSecret;
    }

    public void setAccountSecret(String accountSecret) {
        this.accountSecret = accountSecret;
    }

    /** @return Account Token found in the Settings menu - API Key area on the portal. */
    public String getAcccountToken() {
        return acccountToken;
    }

    public void setAcccountToken(String acccountToken) {
        this.acccountToken = acccountToken;
    }

    /**
     * @return OPTIONAL. If provided, this field will be used to impersonate the API call.
     */
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /** @return Environment where the call is to be executed.  Valid values: sandbox or production, see {@link Enums.Environment}. */
    public Enums.Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Enums.Environment environment) {
        this.environment = environment;
    }

    /** @return Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256", "HMAC-SHA384","HMAC-SHA512" see {@link Enums.SignatureMethod}. */
    public Enums.SignatureMethod getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(Enums.SignatureMethod hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    /** @return Format of the API response call. Valid values: JSON or XML see {@link Enums.Format}. */
    public Enums.Format getResultFormat() {
        return resultFormat;
    }

    public void setResultFormat(Enums.Format resultFormat) {
        this.resultFormat = resultFormat;
    }

    /**
     * Defaults to validating params before querying API
     * Note: Uses Apache Commons validator for validation of email and IP.  Must include this library for validation to work
     * Please see documentation here : https://commons.apache.org/proper/commons-validator/
     * You can disable this by setting to false
     * @return validate ip address and email before sending to the server. True by default.
     */
    public boolean isValidateBeforeSending() {
        return validateBeforeSending;
    }

    public void setValidateBeforeSending(boolean validateBeforeSending) {
        this.validateBeforeSending = validateBeforeSending;
    }

    /** @return Authentication scheme to use.  Valid values: "OAuth1" (Default), "OAuth2" */
    public Enums.AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(Enums.AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }
}
