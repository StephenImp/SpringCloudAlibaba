package com.cn.demoserver1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoServer1Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(6000);// 设置建立连接超时时间  毫秒
        requestFactory.setReadTimeout(6000);// 设置读取数据超时时间  毫秒
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        // jackson配置
        ObjectMapper objectMapper = new ObjectMapper();
        // 配置如果被序列化的对象没有可访问的属性  不报错，返回一个空的bean,即{}
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 创建json消息转换器
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        List<MediaType> mediaTypes = new ArrayList<>(jacksonConverter.getSupportedMediaTypes());
        // 为json消息转换器新增直接text_plain类型  避免遇到响应体是json,而响应头是text/plain类型无法找到适合的解析
        mediaTypes.add(MediaType.TEXT_PLAIN);
        jacksonConverter.setSupportedMediaTypes(mediaTypes);

        List<HttpMessageConverter<?>> messageConverters = Arrays.asList(
                new ByteArrayHttpMessageConverter(),
                new StringHttpMessageConverter(Charset.forName("utf-8")),
                new ResourceHttpMessageConverter(),
                new SourceHttpMessageConverter<>(),
                new FormHttpMessageConverter(),
                jacksonConverter
        );
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
