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

@Entity
@Table(name = "billDetails")
public class BillDetails implements Serializable {

    @Id
    String issuerAgencyId;

    @Column
    String billingAccountId;

    @Column
    String billingCycle;

    @Column
    String dueAmount;

    @Column
    String paidAmount;

    @Column
    String billReferenceInfo;

    @Column
    String agencyCode;

    public BillDetails() {
    }

    public BillDetails(String issuerAgencyId, String billingAccountId, String billingCycle, String dueAmount, String paidAmount, String billReferenceInfo, String agencyCode) {
        this.issuerAgencyId = issuerAgencyId;
        this.billingAccountId = billingAccountId;
        this.billingCycle = billingCycle;
        this.dueAmount = dueAmount;
        this.paidAmount = paidAmount;
        this.billReferenceInfo = billReferenceInfo;
        this.agencyCode = agencyCode;
    }

    public String getIssuerAgencyId() {
        return issuerAgencyId;
    }

    public void setIssuerAgencyId(String issuerAgencyId) {
        this.issuerAgencyId = issuerAgencyId;
    }

    public String getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(String billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public String getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(String dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getBillReferenceInfo() {
        return billReferenceInfo;
    }

    public void setBillReferenceInfo(String billReferenceInfo) {
        this.billReferenceInfo = billReferenceInfo;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    @Override
    public String toString() {
        return "BillDetails{" +
                "issuerAgencyId='" + issuerAgencyId + '\'' +
                ", billingAccountId='" + billingAccountId + '\'' +
                ", billingCycle='" + billingCycle + '\'' +
                ", dueAmount='" + dueAmount + '\'' +
                ", paidAmount='" + paidAmount + '\'' +
                ", billReferenceInfo='" + billReferenceInfo + '\'' +
                ", agencyCode='" + agencyCode + '\'' +
                '}';
    }
}
