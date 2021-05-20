package com.arbpg.mof.controller;

import com.arbpg.mof.model.MofPluginRequest;
import com.fss.plugin.AgencyDetails;
import com.fss.plugin.iPayPipe;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlainTranDataMOFPluginController {


    List<AgencyDetails> agencyDetails = new ArrayList<>();

    @PostMapping("/send_request_mof_plugin")
    public String sendTransactionMOFPlugin(@ModelAttribute("mofPluginRequest") MofPluginRequest mofPluginRequest, Model model) throws Exception {

        iPayPipe pipe = new iPayPipe();
        String resourcePath = "D://Projects//";
        String keystorePath = "D://Projects//";

        SecureRandom random = new SecureRandom();
        StringBuilder resultTrackId = new StringBuilder();
        String dic = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(dic.length());
            resultTrackId.append(dic.charAt(index));
        }
        pipe.setTrackId(String.valueOf(resultTrackId));
        pipe.setResponseURL(mofPluginRequest.getResponseURL());
        pipe.setErrorURL(mofPluginRequest.getErrorURL());
        pipe.setResourcePath(resourcePath);
        pipe.setKeystorePath(keystorePath);
        pipe.setAlias(mofPluginRequest.getAliasName());
        pipe.setAction(mofPluginRequest.getAction());
        pipe.setCurrency(mofPluginRequest.getCurrency());
        pipe.setLanguage(mofPluginRequest.getLanguage());
        pipe.setAmt(mofPluginRequest.getAmount());
        pipe.setUdf1(mofPluginRequest.getUdf1());
        pipe.setUdf2(mofPluginRequest.getUdf2());
        pipe.setUdf3(mofPluginRequest.getUdf3());
        pipe.setUdf4(mofPluginRequest.getUdf4());
        pipe.setUdf5(mofPluginRequest.getUdf5());

        pipe.setPayorIDType(mofPluginRequest.getPayorIDType());
        pipe.setPayorIDNumber(mofPluginRequest.getPayorIDNumber());
        /** For Bank Hosted Payment Integration, the method to be called is **/
        int result = pipe.performPaymentInitializationHTTP();
        //To redirect the web address.
        if (result == 0) {
//            HttpServletResponse response = null;
//            assert false;
//            response.sendRedirect(pipe.getWebAddress());//Redirect to ARB Payment Gateway page
        } else {
            System.out.println(pipe.getError()); //Problem in connecting the ARB Payment Gateway
        }
        return "redirect:" + pipe.getWebAddress();
    }

    @GetMapping("/send_request_mof_plugin")
    public String sendTransactionMOFPlugin(Model model) {
        MofPluginRequest mofPluginRequest = new MofPluginRequest();

        model.addAttribute("mofPluginRequest", mofPluginRequest);
        return "mof_request_send_plugin";
    }

    @PostMapping("/agency_details_mof_plugin")
    public String addAgencyDetail(@ModelAttribute("agencyDetails") AgencyDetails agencyDetail, Model model) {

        agencyDetails.add(agencyDetail);
        model.addAttribute("agencyDetail", agencyDetail);
        return "agency_details_mof_plugin";
    }

    @GetMapping("/agency_details_mof_plugin")
    public String goToAgencyDetails(@ModelAttribute("agencyDetails") AgencyDetails agencyDetails, Model model) {
        model.addAttribute("agencyDetails", agencyDetails);
        return "agency_details_mof_plugin";
    }

    @GetMapping("/final_result_plugin")
    public String finalResultPlugin() {
        return "final_result_plugin";
    }

    @PostMapping("/final_result_plugin")
    public String finalResultPluginShow() {
        return "final_result_plugin";
    }
}
