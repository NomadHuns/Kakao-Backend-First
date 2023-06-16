package com.example.kakaoshop.product;

import lombok.*;

import java.util.List;

public class ProductResponse {

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class FindAllDTO {

        private int id;
        private String productName;
        private String description;
        private String image;
        private int price;
    }


    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class FindByIdDTO {

        private int id;
        private String productName;
        private String description;
        private String image;
        private int price;
        private int starCount; // 0~5
        private List<OptionDTO> options;

        @Getter @Setter @AllArgsConstructor @NoArgsConstructor
        public static class OptionDTO {
            private int id;
            private String optionName;
            private int price;

        }
    }
}
