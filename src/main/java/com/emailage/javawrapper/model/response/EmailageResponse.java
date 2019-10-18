package com.emailage.javawrapper.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailageResponse {

    @JsonProperty("query")
    private EmailageQuery query;

    @JsonProperty("responseStatus")
    private EmailageStatus responseStatus;

    public EmailageQuery getQuery() {
        return query;
    }

    public void setQuery(EmailageQuery query) {
        this.query = query;
    }

    public EmailageStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(EmailageStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
