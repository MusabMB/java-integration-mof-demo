package com.arbpg.mof.controller;

import com.arbpg.mof.model.BillDetails;
import com.arbpg.mof.model.MOFRequest;
import com.arbpg.mof.model.PlainTrandata;
import com.arbpg.mof.model.PlainTrandataRequest;
import com.arbpg.mof.services.PlainTranDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlainTranDataController {

    @Autowired
    private PlainTranDataService plainTranDataService;

    @Autowired
    private PlainTrandata plainTrandata;

    @Autowired
    MOFRequest mofRequest;


    String terminalResourceKey = " ";

    List<BillDetails> billDetailsList = new ArrayList<>();

    @PostMapping("/goToMOFPaymentPage")
    public String sendRequest(@ModelAttribute("MOFRequest") PlainTrandataRequest plainTranDataRequest,Model model) throws Exception {

        SecureRandom random = new SecureRandom();
        StringBuilder resultTrackId = new StringBuilder();
        String dic = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(dic.length());
            resultTrackId.append(dic.charAt(index));
        }
        plainTrandata.setTrackId(String.valueOf(resultTrackId));

        plainTrandata.setAmt(plainTranDataRequest.getAmt());
        plainTrandata.setPassword(plainTranDataRequest.getPassword());
        plainTrandata.setAction(plainTranDataRequest.getAction());
        plainTrandata.setCurrencyCode(plainTranDataRequest.getCurrencyCode());
        plainTrandata.setId(plainTranDataRequest.getId());
        plainTrandata.setLangid(plainTranDataRequest.getLangid());
        plainTrandata.setErrorURL(plainTranDataRequest.getErrorURL());
        plainTrandata.setResponseURL(plainTranDataRequest.getResponseURL());
        plainTrandata.setUdf1(plainTranDataRequest.getUdf1());
        plainTrandata.setUdf2(plainTranDataRequest.getUdf2());
        plainTrandata.setUdf3(plainTranDataRequest.getUdf3());
        plainTrandata.setUdf4(plainTranDataRequest.getUdf4());
        plainTrandata.setUdf5(plainTranDataRequest.getUdf5());
        plainTrandata.setUdf6(plainTranDataRequest.getUdf6());
        plainTrandata.setUdf7(plainTranDataRequest.getUdf7());
        plainTrandata.setUdf8(plainTranDataRequest.getUdf8());
        plainTrandata.setUdf9(plainTranDataRequest.getUdf9());
        plainTrandata.setUdf10(plainTranDataRequest.getUdf10());
        plainTrandata.setPayorIDType(plainTranDataRequest.getPayorIDType());
        plainTrandata.setPayorIDNumber(plainTranDataRequest.getPayorIDNumber());
        plainTrandata.setBillDetails(billDetailsList);
        terminalResourceKey = plainTranDataRequest.getTerminalResourceKey();
        StringBuffer requestToPG = plainTranDataService.buildHostRequest(plainTrandata);
        String encryptedTranData = plainTranDataService.encryptAESPKCS5(String.valueOf(requestToPG), terminalResourceKey);
        mofRequest.setTranportalId(plainTrandata.getId());
        mofRequest.setResponseURL(plainTrandata.getResponseURL());
        mofRequest.setErrorURL(plainTrandata.getErrorURL());
        mofRequest.setTrandata(encryptedTranData);
        model.addAttribute("paymentURL",plainTranDataRequest.getPaymentURL());
        model.addAttribute("responseURL", plainTrandata.getResponseURL());
        model.addAttribute("errorURL", plainTrandata.getErrorURL());
        model.addAttribute("trandata", encryptedTranData);
        model.addAttribute("tranportalId",plainTrandata.getId());
        return "MOFRequest";
    }

    @GetMapping("/goToMOFPaymentPage")
    public String sendTransaction(Model model) {
        PlainTrandataRequest plainTrandataRequest = new PlainTrandataRequest();

        model.addAttribute("plainTranData", plainTrandataRequest);
        return "mof_request_send";
    }

    @PostMapping("/bill_details")
    public String addBillDetail(@ModelAttribute("billDetails") BillDetails billDetails, Model model) {

        billDetailsList.add(billDetails);
        model.addAttribute("billDetails", billDetails);
        return "bill_details";
    }

    @GetMapping("/bill_details")
    public String goToBillDetails(@ModelAttribute("billDetails") BillDetails billDetails, Model model) {
        model.addAttribute("billDetails", billDetails);
        return "bill_details";
    }

}
