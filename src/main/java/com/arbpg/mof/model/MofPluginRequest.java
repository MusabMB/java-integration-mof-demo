package com.arbpg.mof.model;

import javax.persistence.*;

@Entity
@Table(name = "mofPluginRequest")
public class MofPluginRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String trackid;

    @Column
    String action;

    @Column
    String aliasName;

    @Column
    String currency;

    @Column
    String language;

    @Column
    String amount;

    @Column
    String payorIDType;

    @Column
    String payorIDNumber;

    @Column
    String Udf1;

    @Column
    String Udf2;

    @Column
    String Udf3;

    @Column
    String Udf4;

    @Column
    String Udf5;

    @Column
    String responseURL;

    @Column
    String ErrorURL;

    public MofPluginRequest() {
    }

    public MofPluginRequest(String trackid, String action, String aliasName, String currency, String language, String amount, String payorIDType, String payorIDNumber, String udf1, String udf2, String udf3, String udf4, String udf5, String responseURL, String errorURL) {
        this.trackid = trackid;
        this.action = action;
        this.aliasName = aliasName;
        this.currency = currency;
        this.language = language;
        this.amount = amount;
        this.payorIDType = payorIDType;
        this.payorIDNumber = payorIDNumber;
        Udf1 = udf1;
        Udf2 = udf2;
        Udf3 = udf3;
        Udf4 = udf4;
        Udf5 = udf5;
        this.responseURL = responseURL;
        ErrorURL = errorURL;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTrackid() {
        return trackid;
    }

    public void setTrackid(String trackid) {
        this.trackid = trackid;
    }

    public String getPayorIDType() {
        return payorIDType;
    }

    public void setPayorIDType(String payorIDType) {
        this.payorIDType = payorIDType;
    }

    public String getPayorIDNumber() {
        return payorIDNumber;
    }

    public void setPayorIDNumber(String payorIDNumber) {
        this.payorIDNumber = payorIDNumber;
    }

    public String getUdf1() {
        return Udf1;
    }

    public void setUdf1(String udf1) {
        Udf1 = udf1;
    }

    public String getUdf2() {
        return Udf2;
    }

    public void setUdf2(String udf2) {
        Udf2 = udf2;
    }

    public String getUdf3() {
        return Udf3;
    }

    public void setUdf3(String udf3) {
        Udf3 = udf3;
    }

    public String getUdf4() {
        return Udf4;
    }

    public void setUdf4(String udf4) {
        Udf4 = udf4;
    }

    public String getUdf5() {
        return Udf5;
    }

    public void setUdf5(String udf5) {
        Udf5 = udf5;
    }

    public String getResponseURL() {
        return responseURL;
    }

    public void setResponseURL(String responseURL) {
        this.responseURL = responseURL;
    }

    public String getErrorURL() {
        return ErrorURL;
    }

    public void setErrorURL(String errorURL) {
        ErrorURL = errorURL;
    }
}

