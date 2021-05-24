package com.arbpg.mof.services;

import com.arbpg.mof.model.PlainTrandata;
import com.arbpg.mof.model.RequestToPG;
import com.arbpg.mof.repository.PlainTraDataRequestRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;

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

    public String requestFromMerchantToPG(RequestToPG[] requestToPG) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<RequestToPG[]> entity = new HttpEntity<>(requestToPG, headers);
        String result=restTemplate.exchange("https://securepayments.alrajhibank.com.sa/pg/payment/hosted.htm", HttpMethod.POST, entity, String.class).getBody();
        return result;
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
}
