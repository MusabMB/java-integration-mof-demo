package com.arbpg.mof;

import com.arbpg.mof.model.MofPluginRequest;
import com.arbpg.mof.model.PlainTrandata;
import com.arbpg.mof.model.RequestResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MofApplication {

    public static void main(String[] args) {
        SpringApplication.run(MofApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RequestResult getRequestResult() {
        return new RequestResult();
    }

    @Bean
    public PlainTrandata getPlainTrandata() {
        return new PlainTrandata();
    }

    @Bean
    public MofPluginRequest getMOFPluginRequest() {
        return new MofPluginRequest();
    }


}
