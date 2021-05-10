package com.arbpg.mof.model;

import javax.persistence.*;

@Entity
@Table
public class RequestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String status;

    @Column
    String result;

    @Column
    String error;

    @Column
    String errorText;

    public RequestResult() {
    }

    public RequestResult(String status, String result, String error, String errorText) {
        this.status = status;
        this.result = result;
        this.error = error;
        this.errorText = errorText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
