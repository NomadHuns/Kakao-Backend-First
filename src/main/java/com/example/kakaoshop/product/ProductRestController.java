package com.example.kakaoshop.product;

import com.example.kakaoshop._core.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductRestController {

    // 전체 상품 목록 조회
    @GetMapping("/products")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page) {

        // 상품 목록을 담을 리스트 생성
        List<ProductResponse.FindAllDTO> findAllDTOList = new ArrayList<>();

        // 상품 하나씩 집어넣기
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                1, "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전", "", "/images/1.jpg", 1000
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                2, "[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율", "", "/images/2.jpg", 2000
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                3, "삼성전자 JBL JR310 외 어린이용/성인용 헤드셋 3종!", "", "/images/3.jpg", 30000
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                4, "바른 누룽지맛 발효효소 2박스 역가수치보장 / 외 7종", "", "/images/4.jpg", 4000
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                5, "[더주] 컷팅말랑장족, 숏다리 100g/300g 외 주전부리 모음 /중독성 최고/마른안주", "", "/images/5.jpg", 5000
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                6, "굳지않는 앙금절편 1,050g 2팩 외 우리쌀떡 모음전", "", "/images/6.jpg", 15900
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                7, "eoe 이너딜리티 30포, 오렌지맛 고 식이섬유 보충제", "", "/images/7.jpg", 26800
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                8, "제나벨 PDRN 크림 2개. 피부보습/진정 케어", "", "/images/8.jpg", 25900
        ));
        findAllDTOList.add(new ProductResponse.FindAllDTO(
                9, "플레이스테이션 VR2 호라이즌 번들. 생생한 몰입감", "", "/images/9.jpg", 797000
        ));

        return ResponseEntity.ok(ApiUtils.success(findAllDTOList));
    }

    // 개별 상품 상세 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        // 상품을 담을 DTO 생성
        ProductResponse.FindByIdDTO findByIdDTO = null;

        switch (id) {
            case 1 : {
                List<ProductResponse.FindByIdDTO.OptionDTO> optionDTOList = new ArrayList<>();
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(1, "01. 슬라이딩 지퍼백 크리스마스에디션 4종", 10000));
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(2, "02. 슬라이딩 지퍼백 플라워에디션 5종", 10900));
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(3, "고무장갑 베이지 S(소형) 6팩", 9900));
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(4, "뽑아쓰는 키친타올 130매 12팩", 16900));
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(4, "2겹 식빵수세미 6매", 8900));
                findByIdDTO = new ProductResponse.FindByIdDTO(1, "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전", "", "/images/1.jpg", 1000, 5, optionDTOList);
                break;
            }
            case 2 : {
                List<ProductResponse.FindByIdDTO.OptionDTO> optionDTOList = new ArrayList<>();
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(6, "22년산 햇단밤 700g(한정판매)", 9900));
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(7, "22년산 햇단밤 1kg(한정판매)", 14500));
                optionDTOList.add(new ProductResponse.FindByIdDTO.OptionDTO(8, "밤깎기+다회용 구이판 세트", 5500));
                findByIdDTO = new ProductResponse.FindByIdDTO(2, "[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율", "", "/images/2.jpg", 2000, 5, optionDTOList);
            }
        }

        // 존재 하지 않는 상품
        if (findByIdDTO == null) {
            return ResponseEntity.badRequest().body(ApiUtils.error("해당 상품을 찾을 수 없습니다 : " + id, HttpStatus.BAD_REQUEST));
        }

        return ResponseEntity.ok(ApiUtils.success(findByIdDTO));
    }
}
