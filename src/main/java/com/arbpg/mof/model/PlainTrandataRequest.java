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

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class PlainTrandataRequest extends PlainTrandata {

    String terminalResourceKey;

    public PlainTrandataRequest() {
    }

    public PlainTrandataRequest(double amt, int action, String password, String id, int currencyCode, String trackId, String responseURL, String errorURL, String udf1, String udf2, String udf3, String udf4, String udf5, String udf6, String udf7, String udf8, String udf9, String udf10, String langid, String payorIDType, String payorIDNumber, List<BillDetails> billDetails, String terminalResourceKey) {
        super(amt, action, password, id, currencyCode, trackId, responseURL, errorURL, udf1, udf2, udf3, udf4, udf5, udf6, udf7, udf8, udf9, udf10, langid, payorIDType, payorIDNumber, billDetails);
        this.terminalResourceKey = terminalResourceKey;
    }

    public String getTerminalResourceKey() {
        return terminalResourceKey;
    }

    public void setTerminalResourceKey(String terminalResourceKey) {
        this.terminalResourceKey = terminalResourceKey;
    }
}
