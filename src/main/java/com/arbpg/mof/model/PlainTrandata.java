/*
 *
 * Class Name : Plain Trandata Request
 *
 * Version Info : 1.0  06-May-2021
 *
 * Copyright Info : made by (Ahmad Almatari)
 *
 * In this Class it display the trandata that is sent by the
 * merchant to the PG "Bank Hosted".
 *
 */

package com.arbpg.mof.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plainTranDataRequest")
public class PlainTrandata implements Serializable {

    @Column
    double amt;

    @Column
    int action;

    @Column
    String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column
    int currencyCode;

    @Column
    String trackId;

    @Column
    String responseURL;

    @Column
    String errorURL;

    @Column
    String udf1;

    @Column
    String udf2;

    @Column
    String udf3;

    @Column
    String udf4;

    @Column
    String udf5;

    @Column
    String udf6;

    @Column
    String udf7;

    @Column
    String udf8;

    @Column
    String udf9;

    @Column
    String udf10;
    @Column
    String langid;

    @Column
    String payorIDType;

    @Column
    String payorIDNumber;

    @OneToMany
    List<BillDetails> billDetails= new ArrayList<>();

    public PlainTrandata() {
    }

    public PlainTrandata(double amt, int action, String password, String id,
                         int currencyCode, String trackId, String responseURL,
                         String errorURL, String udf1, String udf2, String udf3,
                         String udf4, String udf5, String udf6, String udf7,
                         String udf8, String udf9, String udf10, String langid,
                         String payorIDType, String payorIDNumber, List<BillDetails> billDetails) {
        this.amt = amt;
        this.action = action;
        this.password = password;
        this.id = id;
        this.currencyCode = currencyCode;
        this.trackId = trackId;
        this.responseURL = responseURL;
        this.errorURL = errorURL;
        this.udf1 = udf1;
        this.udf2 = udf2;
        this.udf3 = udf3;
        this.udf4 = udf4;
        this.udf5 = udf5;
        this.udf6 = udf6;
        this.udf7 = udf7;
        this.udf8 = udf8;
        this.udf9 = udf9;
        this.udf10 = udf10;
        this.langid = langid;
        this.payorIDType = payorIDType;
        this.payorIDNumber = payorIDNumber;
        this.billDetails = billDetails;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getUdf1() {
        return udf1;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    public String getUdf2() {
        return udf2;
    }

    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    public String getUdf3() {
        return udf3;
    }

    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    public String getUdf4() {
        return udf4;
    }

    public void setUdf4(String udf4) {
        this.udf4 = udf4;
    }

    public String getUdf5() {
        return udf5;
    }

    public void setUdf5(String udf5) {
        this.udf5 = udf5;
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

    public String getLangid() {
        return langid;
    }

    public void setLangid(String langid) {
        this.langid = langid;
    }

    public String getUdf6() {
        return udf6;
    }

    public void setUdf6(String udf6) {
        this.udf6 = udf6;
    }

    public String getUdf7() {
        return udf7;
    }

    public void setUdf7(String udf7) {
        this.udf7 = udf7;
    }

    public String getUdf8() {
        return udf8;
    }

    public void setUdf8(String udf8) {
        this.udf8 = udf8;
    }

    public String getUdf9() {
        return udf9;
    }

    public void setUdf9(String udf9) {
        this.udf9 = udf9;
    }

    public String getUdf10() {
        return udf10;
    }

    public void setUdf10(String udf10) {
        this.udf10 = udf10;
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

    public List<BillDetails> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetails> billDetails) {
        this.billDetails = billDetails;
    }
}
