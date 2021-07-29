package com.arbpg.mof.services;

import com.arbpg.mof.model.BillDetails;
import com.arbpg.mof.model.PlainTrandata;
import com.arbpg.mof.repository.PlainTraDataRequestRepository;
import com.google.gson.Gson;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Service
public class PlainTranDataService {

    @Autowired
    private PlainTraDataRequestRepository plainTraDataRequestRepository;

    @Autowired
    RestTemplate restTemplate;

    private static final String HEX_DIGITS = "0123456789abcdef";
    public static String AES_IV = "PGKEYENCDECIVSPC";

    static {
        PlainTranDataService.AES_IV = "PGKEYENCDECIVSPC";
    }

    public String encryptAESPKCS5(final String encryptString, final String key) throws Exception {
        byte[] encryptedText = null;
        String encryptedData = null;
        IvParameterSpec ivspec = null;
        SecretKeySpec skeySpec = null;
        Cipher cipher = null;
        byte[] text = null;
        String result=null;
        try {
            ivspec = new IvParameterSpec(PlainTranDataService.AES_IV.getBytes("UTF-8"));
            skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, skeySpec, ivspec);
            text = encryptString.getBytes("UTF-8");
            encryptedText = cipher.doFinal(text);
            encryptedData = Base64.encodeBase64String(encryptedText);
            result= javax.xml.bind.DatatypeConverter.printHexBinary(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
            return encryptedData;
        } finally {
            encryptedText = null;
            ivspec = null;
            skeySpec = null;
            cipher = null;
            text = null;
        }
        encryptedText = null;
        ivspec = null;
        skeySpec = null;
        cipher = null;
        text = null;
        return result;
    }

    public static String decryptAES(final String key, final String encryptedString) throws Exception {
        SecretKeySpec skeySpec = null;
        IvParameterSpec ivspec = null;
        Cipher cipher = null;
        byte[] textDecrypted = null;
        try {
            final byte[] b = hexStringToByteArray(encryptedString);
            skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            ivspec = new IvParameterSpec(PlainTranDataService.AES_IV.getBytes("UTF-8"));
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, skeySpec, ivspec);
            textDecrypted = cipher.doFinal(b);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new String(textDecrypted);
        }
        finally {
            skeySpec = null;
            ivspec = null;
            cipher = null;
        }
        skeySpec = null;
        ivspec = null;
        cipher = null;
        return new String(textDecrypted);
    }

    public String getFinalURL(String result) {
        return result.substring(19)+"?PaymentID="+result.substring(0,18);
    }

    public static byte[] hexStringToByteArray(final String s) {
        final int len = s.length();
        final byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String decode(String url)
    {
        try {
            String prevURL="";
            String decodeURL=url;
            while(!prevURL.equals(decodeURL))
            {
                prevURL=decodeURL;
                decodeURL= URLDecoder.decode( decodeURL, "UTF-8" );
            }
            return decodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Issue while decoding" +e.getMessage();
        }
    }
    public String convert(String a) {
        StringBuilder res = new StringBuilder("{\"");

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '=') {
                res.append("\"" + ":" + "\"");
            } else if (a.charAt(i) == '&') {
                res.append("\"" + "," + "\"");
            } else {
                res.append(a.charAt(i));
            }
        }
        res.append("\"" + "}");
        return res.toString();
    }

    public synchronized StringBuffer buildHostRequest(PlainTrandata plainTrandata)
    {
        String amt = String.valueOf(plainTrandata.getAmt());
        String action = String.valueOf(plainTrandata.getAction());
        String responseURL = String.valueOf(plainTrandata.getResponseURL());
        String errorURL = String.valueOf(plainTrandata.getErrorURL());
        String trackId = String.valueOf(plainTrandata.getTrackId());
        String udf1 = String.valueOf(plainTrandata.getUdf1());
        String udf2 = String.valueOf(plainTrandata.getUdf2());
        String udf3 = String.valueOf(plainTrandata.getUdf3());
        String udf4 = String.valueOf(plainTrandata.getUdf4());
        String udf5 = String.valueOf(plainTrandata.getUdf5());
        String udf6 = String.valueOf(plainTrandata.getUdf6());
        String udf7 = String.valueOf(plainTrandata.getUdf7());
        String udf8 = String.valueOf(plainTrandata.getUdf8());
        String udf9 = String.valueOf(plainTrandata.getUdf9());
        String udf10 = String.valueOf(plainTrandata.getUdf10());
        String currency = String.valueOf(plainTrandata.getCurrencyCode());
        String language = String.valueOf(plainTrandata.getLangid());
        String id = String.valueOf(plainTrandata.getId());
        String password = String.valueOf(plainTrandata.getPassword());
        List<BillDetails> billDetails = plainTrandata.getBillDetails();



        StringBuffer requestbuffer;
        try
        {
            requestbuffer = new StringBuffer();

            //Note this method is placed in the same class. So, we didn't use getters.
            if(amt.length() > 0)
            {
                requestbuffer.append("amt="+amt+"&");
            }
            if(action.length() > 0)
            {
                requestbuffer.append("action="+action+"&");
            }
            if(responseURL.length() > 0)
            {
                requestbuffer.append("responseURL="+responseURL+"&");
            }
            if(errorURL.length() > 0)
            {
                requestbuffer.append("errorURL="+errorURL+"&");
            }
            if(trackId.length() > 0)
            {
                requestbuffer.append("trackid="+trackId+"&");
            }
            if(udf1.length() > 0)
            {
                requestbuffer.append("udf1="+udf1+"&");
            }
            if(udf2.length() > 0)
            {
                requestbuffer.append("udf2="+udf2+"&");
            }
            if(udf3.length() > 0)
            {
                requestbuffer.append("udf3="+udf3+"&");
            }
            if(udf4.length() > 0)
            {
                requestbuffer.append("udf4="+udf4+"&");
            }
            if(udf5.length() > 0)
            {
                requestbuffer.append("udf5="+udf5+"&");
            }
            if(udf6.length() > 0)
            {
                requestbuffer.append("udf6="+udf6+"&");
            }
            if(udf7.length() > 0)
            {
                requestbuffer.append("udf7="+udf7+"&");
            }
            if(udf8.length() > 0)
            {
                requestbuffer.append("udf8="+udf8+"&");
            }
            if(udf9.length() > 0)
            {
                requestbuffer.append("udf9="+udf9+"&");
            }
            if(udf10.length() > 0)
            {
                requestbuffer.append("udf10="+udf10+"&");
            }
            if(currency.length() > 0)
            {
                requestbuffer.append("currencycode="+currency+"&");
            }
            if(language.length() > 0)
            {
                requestbuffer.append("langid="+language+"&");
            }
            if(id.length() > 0)
            {
                requestbuffer.append("id="+id+"&");
            }
            if(password.length() > 0)
            {
                requestbuffer.append("password="+password);
            }
            if(billDetails!=null && billDetails.size() > 0)
            {
                //requestbuffer.append("billDetails="+AgencyDetails+"&");
                String json = new Gson().toJson(billDetails);
                requestbuffer.append("&billDetails=" + json);
            }
            return requestbuffer;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            requestbuffer = null;
        }
    }
}
