package com.example.kakaoshop.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class OrderRestController {

    @Autowired
    private ResourceLoader resourceLoader;

    // 결재
    @PostMapping("/orders/save")
    public ResponseEntity<?> save() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:mock/order/detail.json");
        InputStream inputStream = resource.getInputStream();
        String jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        return ResponseEntity.ok(jsonString);
    }

    // 주문 결과 확인
    @GetMapping("/orders/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) throws IOException {
        String jsonString;

        if (id == 1) {
            Resource resource = resourceLoader.getResource("classpath:mock/order/detail1.json");
            InputStream inputStream = resource.getInputStream();
            jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } else {
            Resource resource = resourceLoader.getResource("classpath:mock/order/detail2.json");
            InputStream inputStream = resource.getInputStream();
            jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }


        return ResponseEntity.ok(jsonString);
    }

}

