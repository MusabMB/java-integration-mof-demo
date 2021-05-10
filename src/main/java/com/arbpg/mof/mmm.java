package com.arbpg.mof;

import com.arbpg.mof.model.BillDetails;
import com.arbpg.mof.model.FinalResult;
import com.arbpg.mof.services.PlainTranDataService;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Scratch {

//    private static final String HEX_DIGITS = "0123456789abcdef";
//    public static String AES_IV = "PGKEYENCDECIVSPC";
//
//    static {
//        Scratch.AES_IV = "PGKEYENCDECIVSPC";
//    }
    
    public static void main(String[] args) throws Exception {
        
        

//        String result ="paymentid=600202112935833683&trackid=aUqbAb9v3y&tranid=&trandata=8C3AE85822A6CFED7C805B96915B9E338F21E19F25AF077EAF84B74ACFDB0DA8FC78A129162383826793FEA923E1DDA91DE6A214234F6BB65D4CC4DB34067B111C70A07F9AB7A10467B2E1EE6E7096C19D6E29D9075B50FF4E8A4A273DB42FD3B7AF1EED4EBCED55F86C07C60E3E7D62ACDBD55BCE1584C024B20392E1484B9306DFEEFF21193DDF1E5A1B15EE896AA018E981715D2DE18CD8BD012554C10009F60A28D45BC13D848CC216BE4E4CA6F28010CE3EF46C4E929A3E76A35B1259E42396EE942B243D6B2C43DD8B41C5A8134483E103B5591775AFE0221746689E55432D7815D7F52EDDFCAD28C2572D88F1BBC325E549E47D15AC638B333A12EE939599C36ADD30B4008F68053FFB199C292ABF6141D51123223DF6619AA1254D3C919B56022F663C71B2B66819A8722CC232251CDFA410600EF86AC82C6A4EF38A6A054C62862E79A1456245D5F9D835987EE7080EC11FE86336FA657FD3E07337CF4BF04DCC8E67BA5D5FA210F1B0E27B096FB09F7E874D8B4243A26CFB9E45E8331BAD59ACDFE2BF52423D6212FE9606B9D75387648AE180C1A54D45F8FC3690CAC0DF88B79D04863E3AD085428865FA2E5EB158A1483001D7299987359BFAC7FCE0A5C35C0F4067F3F6CB8A307788260B212B29F15A1734F9074844FF4B47CFC9F36C0A65B94145379E405BFB004BE4295D18647FF36830E03153B1DD0BC4CF54C80AE39587F83FFCA4F5AA50FF6518085D8DDEF634C696170C1A6A6229E803&auth=&ref=&amt=&result=&udf1=&udf2=&udf3=&udf4=&udf5=&udf6=&udf7=&udf8=&udf9=&udf10=&postdate=&avr=&authRespCode=";
////        String[] mm = result.split("&");
////        System.out.println(Arrays.toString(mm) +"************");
//        result=result.substring(65,1153);
//
////        System.out.println(decryptAES("10730561291410730561291410730561",result));
//        String dd=decryptAES("10730561291410730561291410730561",result);
////        PlainTranDataService plainTranDataService = new PlainTranDataService();
////        String mm =plainTranDataService.decryptAESPKCS5(result,"10730561291410730561291410730561");
////        byte[] bytes = javax.xml.bind.DatatypeConverter.parseHexBinary(result);
//
//        System.out.println(decode(dd));

//        System.out.println(result);

//        System.out.println(result.length()+65);
//        Gson g = new Gson();
////        FinalResult finalResult = g.fromJson(result, FinalResult.class);
//        BillDetails billDetails = g.fromJson(result, BillDetails.class);
//
//        System.out.println(billDetails.getAgencyCode());

//        JSONObject jsonObject = new JSONObject();
//        JSONArray list = new JSONArray(mm);
//        jsonObject.put("Item",list);

//        String result="600202112692636685:https://securepayments.alrajhibank.com.sa/pg/paymentpage.htm";
//        String paymentId= result.substring(0,18);
//        String paymentURL= result.substring(19);
//        String finalURL=paymentURL+"?PaymentID="+paymentId;
//        System.out.println(finalURL);
//        System.out.println(paymentId);
//        System.out.println(paymentURL);

//        SecureRandom random = new SecureRandom();
//        StringBuilder result = new StringBuilder();
//        String dic = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        for (int i = 0; i < 10; i++) {
//            int index = random.nextInt(dic.length());
//            result.append(dic.charAt(index));
//        }
//        System.out.println(result);

//        BillDetails billDetail = new BillDetails();
//        billDetail.setAgencyCode("res1");
//        billDetail.setBillingAccountId("res2");
//        billDetail.setBillReferenceInfo("res3");
//        billDetail.setDueAmount("res4");
//        billDetail.setBillingCycle("res5");
//        billDetail.setIssuerAgencyId("res6");
//        billDetail.setPaidAmount("res7");
//
//        List<BillDetails> billDetails = new ArrayList<>();
//        billDetails.add(billDetail);
//
////        billDetails.get(0).setPaidAmount("mmmmmmmmmmmm");
//
//        System.out.println(billDetails);


////        iPayPipe pipe = new iPayPipe();
//        String resourcePath = “c:\\resourcepath”; // Mandatory
//        String keystorePath = “c:\\resourcepath”; // Mandatory
//// 1 – Purchase
//        String action ="1"; // Mandatory
////Terminal Alias Name. Mandatory
//        String aliasName = "MOF10002";
////Transaction Currency. Mandatory
//        String currency = "682";
////Optional
//        String language = "ar";
////Transaction Amount. Mandatory
//        String amount = "20";
////Merchant Track ID. Mandatory, Merchant should ensure the uniqueness.
//        String trackid = "jhaiuhvlkjvh";
////Payor ID details
//        String payorIDType = "3654651651"; // Mandatory
//        String payorIDNumber = "5651651651651651"; // Mandatory
//
////User Defined Fields.
//        String Udf1 = "test"; // Optional
//        String Udf2 = "test"; // Optional
//        String Udf3 = "test"; // Optional
//        String Udf4 = "test"; // Optional
//        String Udf5 = "test"; // Optional
////Set Values
//        pipe.setResourcePath(resourcePath);
//        pipe.setKeystorePath(keystorePath);
//        pipe.setAlias(aliasName);
//        pipe.setAction(action);
//        pipe.setCurrency(currency);
//        pipe.setLanguage(language);
//        pipe.setAmt(amount);
//        pipe.setTrackId(trackid);
//        pipe.setUdf1(Udf1);
//        pipe.setUdf2(Udf2);
//        pipe.setUdf3(Udf3);
//        pipe.setUdf4(Udf4);
//        pipe.setUdf5(Udf5);
//Added for MOF
//        pipe.setPayorIDType(payorIDType);
//        pipe.setPayorIDNumber(payorIDNumber);
//MOF Agency details
//        String billingCycle = "123456";
//        String billingCycle1 = "123456";
//        String billingCycle2 = "123456";
//        AgencyDetails agencyDetails = new AgencyDetails();
//        agencyDetails.setPaidAmount("100.00");
//        agencyDetails.setBillingAccountId("748596415263");
//        if (billingCycle != null && billingCycle.length() > 0) {
//            agencyDetails.setBillingCycle(billingCycle);
//        }
//        agencyDetails.setBillReferenceInfo("748596415266");
//        agencyDetails.setDueAmount("100.00");
//        agencyDetails.setIssuerAgencyId("748596415268");
//        agencyDetails.setAgencyCode("1234");
//        AgencyDetails agencyDetails2 = new AgencyDetails();
//        agencyDetails2.setPaidAmount("100.00");
//        agencyDetails2.setBillingAccountId("748596415263");
//        if (billingCycle1 != null && billingCycle1.length() > 0) {
//            agencyDetails.setBillingCycle(billingCycle1);
//        }
//        agencyDetails2.setBillReferenceInfo("748596415266");
//        agencyDetails2.setDueAmount("100.00");
//        agencyDetails2.setIssuerAgencyId("748596415268");
//        agencyDetails.setAgencyCode("1286");
//        AgencyDetails agencyDetails3 = new AgencyDetails();
//        agencyDetails3.setPaidAmount("100.00");
//        agencyDetails3.setBillingAccountId("748596415263");
//        if (billingCycle2 != null && billingCycle2.length() > 0) {
//            agencyDetails.setBillingCycle(billingCycle);
//        }
//        agencyDetails3.setBillReferenceInfo("748596415266");
//        agencyDetails3.setDueAmount("100.00");
//        agencyDetails3.setIssuerAgencyId("748596415268");
//        agencyDetails3.setAgencyCode("1596");
//        List<AgencyDetails> list = new ArrayList<>();
//        list.add(agencyDetails);
//        list.add(agencyDetails2);
//        list.add(agencyDetails3);
//        pipe.setAgencyDetails(list);
////MOF Agency details
///** For Bank Hosted Payment Integration, the method to be called is **/
//        int result = pipe.performPaymentInitializationHTTP();
////To redirect the web address.
//        if (result == 0) {
////            response.sendRedirect(pipe.getWebAddress());//Redirect to ARB Payment Gateway page
//        } else {
//            System.out.println(pipe.getError()); //Problem in connecting the ARB Payment Gateway
//        }

    }

//    public static String decryptAES(final String key, final String encryptedString) throws Exception {
//        SecretKeySpec skeySpec = null;
//        IvParameterSpec ivspec = null;
//        Cipher cipher = null;
//        byte[] textDecrypted = null;
//        try {
//            final byte[] b = hexStringToByteArray(encryptedString);
//            skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
//            ivspec = new IvParameterSpec(Scratch.AES_IV.getBytes("UTF-8"));
//            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            cipher.init(2, skeySpec, ivspec);
//            textDecrypted = cipher.doFinal(b);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return new String(textDecrypted);
//        }
//        finally {
//            skeySpec = null;
//            ivspec = null;
//            cipher = null;
//        }
//        skeySpec = null;
//        ivspec = null;
//        cipher = null;
//        return new String(textDecrypted);
//    }

//    public static byte[] hexStringToByteArray(final String s) {
//        final int len = s.length();
//        final byte[] data = new byte[len / 2];
//        for (int i = 0; i < len; i += 2) {
//            data[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
//        }
//        return data;
//    }
//
//    public static String decode(String url)
//    {
//        try {
//            String prevURL="";
//            String decodeURL=url;
//            while(!prevURL.equals(decodeURL))
//            {
//                prevURL=decodeURL;
//                decodeURL= URLDecoder.decode( decodeURL, "UTF-8" );
//            }
//            return decodeURL;
//        } catch (UnsupportedEncodingException e) {
//            return "Issue while decoding" +e.getMessage();
//        }
//    }
}