package com.example.order.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public String add() throws Exception {
        System.out.println("下单成功");
        // 设置请求头，请求类型为json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //用HttpEntity封装整个请求报文
        HttpEntity<HashMap<String, Object>> request = new HttpEntity<>(null, headers);
        String msg = restTemplate.postForObject(new URI("http://localhost:8011/stocks"), request, String.class);
        return "下单成功" + msg;
    }

}
