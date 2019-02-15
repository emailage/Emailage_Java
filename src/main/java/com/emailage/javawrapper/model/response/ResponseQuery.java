package com.emailage.javawrapper.model.response;

public class ResponseQuery {
    private EmailageResponse query;
    private EmailageStatus responseStatus;

    public EmailageResponse getQuery() {
        return query;
    }

    public void setQuery(EmailageResponse query) {
        this.query = query;
    }

    public EmailageStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(EmailageStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
