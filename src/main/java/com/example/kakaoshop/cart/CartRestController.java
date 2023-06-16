package com.example.kakaoshop.cart;

import com.example.kakaoshop._core.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class CartRestController {

    @Autowired
    private ResourceLoader resourceLoader;

    // (기능8) 장바구니 담기
    @PostMapping("/carts/add")
    public ResponseEntity<?> addCartList(@RequestBody @Valid List<CartRequest.SaveDTO> saveDTOList, Errors errors) {
        return ResponseEntity.ok(ApiUtils.success(null));
    }

    // (기능11) 주문하기 - (장바구니 업데이트)
    @PostMapping("/carts/update")
    public ResponseEntity<?> update(@RequestBody @Valid List<CartRequest.UpdateDTO> updateDTOList) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:mock/cart/detail.json");
        InputStream inputStream = resource.getInputStream();
        String jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        return ResponseEntity.ok(jsonString);
    }

    // (기능9) 장바구니 보기 - (주문화면, 결재화면)
    @GetMapping("/carts")
    public ResponseEntity<?> findAll() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:mock/cart/update.json");
        InputStream inputStream = resource.getInputStream();
        String jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);


        return ResponseEntity.ok(jsonString);
    }

}
