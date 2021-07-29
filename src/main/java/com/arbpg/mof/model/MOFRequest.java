package com.arbpg.mof.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class MOFRequest {


    String tranportalId;

    String responseURL;

    String errorURL;

    String trandata;

    public MOFRequest() {
    }

    public MOFRequest(String tranportalId, String responseURL, String errorURL, String trandata) {
        this.tranportalId = tranportalId;
        this.responseURL = responseURL;
        this.errorURL = errorURL;
        this.trandata = trandata;
    }

    public String getTranportalId() {
        return tranportalId;
    }

    public void setTranportalId(String tranportalId) {
        this.tranportalId = tranportalId;
    }

    public String getResponseURL() {
        return responseURL;
    }

    public void setResponseURL(String responseURL) {
        this.responseURL = responseURL;
    }

    public String getErrorURL() {
        return errorURL;
    }

    public void setErrorURL(String errorURL) {
        this.errorURL = errorURL;
    }

    public String getTrandata() {
        return trandata;
    }

    public void setTrandata(String trandata) {
        this.trandata = trandata;
    }
}
