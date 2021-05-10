package com.arbpg.mof.model;

import javax.persistence.*;

@Entity
@Table(name = "final_result")
public class FinalResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String paymentid;

    @Column
    String trackid;

    @Column
    String tranid;

    @Column
    String trandata;

    @Column
    String auth;

    @Column
    String ref;

    @Column
    String amt;

    @Column
    String result;

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
    String postdate;

    @Column
    String avr;

    @Column
    String authRespCode;

    public FinalResult() {
    }

    public FinalResult(String paymentid, String trackid, String tranid, String trandata, String auth, String ref, String amt, String result, String udf1, String udf2, String udf3, String udf4, String udf5, String udf6, String udf7, String udf8, String udf9, String udf10, String postdate, String avr, String authRespCode) {
        this.paymentid = paymentid;
        this.trackid = trackid;
        this.tranid = tranid;
        this.trandata = trandata;
        this.auth = auth;
        this.ref = ref;
        this.amt = amt;
        this.result = result;
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
        this.postdate = postdate;
        this.avr = avr;
        this.authRespCode = authRespCode;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getTrackid() {
        return trackid;
    }

    public void setTrackid(String trackid) {
        this.trackid = trackid;
    }

    public String getTranid() {
        return tranid;
    }

    public void setTranid(String tranid) {
        this.tranid = tranid;
    }

    public String getTrandata() {
        return trandata;
    }

    public void setTrandata(String trandata) {
        this.trandata = trandata;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getAvr() {
        return avr;
    }

    public void setAvr(String avr) {
        this.avr = avr;
    }

    public String getAuthRespCode() {
        return authRespCode;
    }

    public void setAuthRespCode(String authRespCode) {
        this.authRespCode = authRespCode;
    }
}
