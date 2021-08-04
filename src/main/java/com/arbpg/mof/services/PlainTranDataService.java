package com.arbpg.mof.services;

import com.arbpg.mof.model.BillDetails;
import com.arbpg.mof.model.PlainTrandata;
import com.google.gson.Gson;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class PlainTranDataService {

    public static String AES_IV = "PGKEYENCDECIVSPC";

    static {
        PlainTranDataService.AES_IV = "PGKEYENCDECIVSPC";
    }

    public String encryptAESPKCS5(final String encryptString, final String key) {
        byte[] encryptedText;
        String encryptedData = null;
        IvParameterSpec ivspec;
        SecretKeySpec skeySpec;
        Cipher cipher;
        byte[] text;
        String result;
        try {
            ivspec = new IvParameterSpec(PlainTranDataService.AES_IV.getBytes(StandardCharsets.UTF_8));
            skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, skeySpec, ivspec);
            text = encryptString.getBytes(StandardCharsets.UTF_8);
            encryptedText = cipher.doFinal(text);
            encryptedData = Base64.encodeBase64String(encryptedText);
            result= javax.xml.bind.DatatypeConverter.printHexBinary(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
            return encryptedData;
        }
        return result;
    }

    public static String decryptAES(final String key, final String encryptedString) {
        SecretKeySpec skeySpec;
        IvParameterSpec ivspec;
        Cipher cipher;
        byte[] textDecrypted = null;
        try {
            final int len = encryptedString.length();
            final byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte)((Character.digit(encryptedString.charAt(i), 16) << 4) + Character.digit(encryptedString.charAt(i + 1), 16));
            }
            skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            ivspec = new IvParameterSpec(PlainTranDataService.AES_IV.getBytes(StandardCharsets.UTF_8));
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, skeySpec, ivspec);
            textDecrypted = cipher.doFinal(data);
        }
        catch (Exception e) {
            e.printStackTrace();
            assert false;
            return new String(textDecrypted);
        }
        return new String(textDecrypted);
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
                requestbuffer.append("amt=").append(amt).append("&");
            }
            if(action.length() > 0)
            {
                requestbuffer.append("action=").append(action).append("&");
            }
            if(responseURL.length() > 0)
            {
                requestbuffer.append("responseURL=").append(responseURL).append("&");
            }
            if(errorURL.length() > 0)
            {
                requestbuffer.append("errorURL=").append(errorURL).append("&");
            }
            if(trackId.length() > 0)
            {
                requestbuffer.append("trackid=").append(trackId).append("&");
            }
            if(udf1.length() > 0)
            {
                requestbuffer.append("udf1=").append(udf1).append("&");
            }
            if(udf2.length() > 0)
            {
                requestbuffer.append("udf2=").append(udf2).append("&");
            }
            if(udf3.length() > 0)
            {
                requestbuffer.append("udf3=").append(udf3).append("&");
            }
            if(udf4.length() > 0)
            {
                requestbuffer.append("udf4=").append(udf4).append("&");
            }
            if(udf5.length() > 0)
            {
                requestbuffer.append("udf5=").append(udf5).append("&");
            }
            if(udf6.length() > 0)
            {
                requestbuffer.append("udf6=").append(udf6).append("&");
            }
            if(udf7.length() > 0)
            {
                requestbuffer.append("udf7=").append(udf7).append("&");
            }
            if(udf8.length() > 0)
            {
                requestbuffer.append("udf8=").append(udf8).append("&");
            }
            if(udf9.length() > 0)
            {
                requestbuffer.append("udf9=").append(udf9).append("&");
            }
            if(udf10.length() > 0)
            {
                requestbuffer.append("udf10=").append(udf10).append("&");
            }
            if(currency.length() > 0)
            {
                requestbuffer.append("currencycode=").append(currency).append("&");
            }
            if(language.length() > 0)
            {
                requestbuffer.append("langid=").append(language).append("&");
            }
            if(id.length() > 0)
            {
                requestbuffer.append("id=").append(id).append("&");
            }
            if(password.length() > 0)
            {
                requestbuffer.append("password=").append(password);
            }
            if(billDetails!=null && billDetails.size() > 0)
            {
                String json = new Gson().toJson(billDetails);
                requestbuffer.append("&billDetails=").append(json);
            }
            return requestbuffer;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
