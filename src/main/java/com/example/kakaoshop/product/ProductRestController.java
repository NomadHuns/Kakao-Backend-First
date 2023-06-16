package com.example.kakaoshop.product;

import com.example.kakaoshop._core.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class ProductRestController {

    @Autowired
    private ResourceLoader resourceLoader;

    // 전체 상품 목록 조회
    @GetMapping("/products")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:mock/product/list.json");
        InputStream inputStream = resource.getInputStream();
        String jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        return ResponseEntity.ok(jsonString);
    }

    // 개별 상품 상세 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) throws IOException {

        String jsonString;

        switch (id) {
            case 1 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail1.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 2 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail2.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 3 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail3.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 4 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail4.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 5 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail5.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 6 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail6.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 7 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail7.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 8 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail8.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            case 9 : {
                Resource resource = resourceLoader.getResource("classpath:mock/product/detail9.json");
                InputStream inputStream = resource.getInputStream();
                jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                break;
            }
            default:
                return ResponseEntity.badRequest().body(ApiUtils.error("해당 상품을 찾을 수 없습니다 : " + id, HttpStatus.BAD_REQUEST));
        }

        return ResponseEntity.ok(jsonString);
    }
}
