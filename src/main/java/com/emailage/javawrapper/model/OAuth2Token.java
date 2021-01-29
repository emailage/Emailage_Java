package com.emailage.javawrapper.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuth2Token {
    private int accessExpiration;
    private String accessToken;
    private String refreshToken;
    private String tokenType;

    @JsonProperty("expires_in")
    public int getAccessExpiration() {
        return accessExpiration;
    }

    public void setAccessExpiration(int accessExpiration) {
        this.accessExpiration = accessExpiration;
    }

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

}
