package com.arbpg.mof.model;

import javax.persistence.*;

@Entity
@Table
public class RequestToPG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column
    String trandata;

    @Column
    String responseURL;

    @Column
    String errorURL;

    public RequestToPG() {
    }

    public RequestToPG(String id, String trandata, String responseURL, String errorURL) {
        this.id = id;
        this.trandata = trandata;
        this.responseURL = responseURL;
        this.errorURL = errorURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrandata() {
        return trandata;
    }

    public void setTrandata(String trandata) {
        this.trandata = trandata;
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
}
