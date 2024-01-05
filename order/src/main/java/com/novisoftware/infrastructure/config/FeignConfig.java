package com.novisoftware.infrastructure.config;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class FeignConfig {

    private ObjectFactory<HttpMessageConverters> messageConverters = HttpMessageConverters::new;
    @Bean
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(() -> new HttpMessageConverters(new RestTemplate().getMessageConverters())));
    }

    @Bean
    Decoder feignFormDecoder() {
        return new SpringDecoder(messageConverters);
    }
}
