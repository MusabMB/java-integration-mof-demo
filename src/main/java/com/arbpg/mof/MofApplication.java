package com.arbpg.mof;

import com.arbpg.mof.model.MOFRequest;
import com.arbpg.mof.model.PlainTrandata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
    public PlainTrandata getPlainTrandata() {
        return new PlainTrandata();
    }

    @Bean
    public MOFRequest getMOFRequest() {
        return new MOFRequest();
    }

}
