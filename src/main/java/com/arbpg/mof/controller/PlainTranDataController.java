package com.arbpg.mof.controller;

import com.arbpg.mof.model.*;
import com.arbpg.mof.services.PlainTranDataService;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlainTranDataController {

    @Autowired
    private PlainTranDataService plainTranDataService;

    @Autowired
    private RequestResult requestResult;

    @Autowired
    private PlainTrandata plainTrandata;

    @Autowired
    RestTemplate restTemplate;

    String finalURL = " ";

    String terminalResourceKey = " ";

    List<BillDetails> billDetailsList = new ArrayList<>();

    @PostMapping("/sendRequest")
    public String sendRequest(@ModelAttribute("plainTranDataRequest") PlainTrandataRequest plainTranDataRequest, Model model) throws Exception {

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
        PlainTrandata[] plainTrandataRequestAsArray = {plainTrandata};
        String jsonPlainTranData = new Gson().toJson(plainTrandataRequestAsArray);
        String encryptedTranData = plainTranDataService.encryptAESPKCS5(jsonPlainTranData, terminalResourceKey);
        RequestToPG requestToPG = new RequestToPG();
        requestToPG.setId(plainTranDataRequest.getId());
        requestToPG.setTrandata(encryptedTranData);
        requestToPG.setResponseURL(plainTranDataRequest.getResponseURL());
        requestToPG.setErrorURL(plainTranDataRequest.getErrorURL());
        RequestToPG[] requestToPGList = {requestToPG};
        String jsonRequestToPGList = new Gson().toJson(requestToPGList);
        String requestResultToPg = plainTranDataService.requestFromMerchantToPG(requestToPGList);
        JSONArray resultArray = new JSONArray(requestResultToPg);
        boolean goToFinalURL = false;
        for (int i = 0; i < resultArray.length(); i++) {
            JSONObject object = resultArray.getJSONObject(i);
            requestResult.setStatus(object.getString("status"));
            if (requestResult.getStatus().equals("1")) {
                requestResult.setResult(object.getString("result"));
                goToFinalURL = true;
                finalURL = plainTranDataService.getFinalURL(requestResult.getResult());
            } else {
                requestResult.setError(object.getString("error"));
                requestResult.setErrorText(object.getString("errorText"));
            }
        }
        model.addAttribute("requestToPG", jsonRequestToPGList);
        model.addAttribute("jsonPlainTranData", jsonPlainTranData);
        model.addAttribute("resultArray", resultArray);
        model.addAttribute("goToFinalURL", goToFinalURL);
        model.addAttribute("requestResult", new Gson().toJson(requestResult.getStatus()));

        return "request_result";
    }

    @GetMapping("/sendTransaction")
    public String sendTransaction(Model model) {
        PlainTrandataRequest plainTrandataRequest = new PlainTrandataRequest();

        model.addAttribute("plainTranData", plainTrandataRequest);
        return "mof_request_send";
    }

    @GetMapping("/goTo3DSecure")
    public String goTo3DSecure() {
        return "redirect:" + finalURL;
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

    @PostMapping("/final_result")
    public String finalResponse(Model model, @RequestBody String result) throws Exception {

        model.addAttribute("final_response", result);

        Gson g = new Gson();
        FinalResult finalResult = g.fromJson(plainTranDataService.convert(result), FinalResult.class);
        String encryptedTranData = finalResult.getTrandata();
        String decryptedTranData = PlainTranDataService.decode(PlainTranDataService.decryptAES(terminalResourceKey, encryptedTranData));
        model.addAttribute("decryptedTranData", plainTranDataService.convert(decryptedTranData));

        return "final_result";
    }

}
