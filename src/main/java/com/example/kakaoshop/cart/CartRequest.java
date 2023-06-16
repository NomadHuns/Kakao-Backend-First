package com.example.kakaoshop.cart;

import lombok.*;

public class CartRequest {

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class SaveDTO {
        private int optionId;
        private int quantity;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class UpdateDTO {
        private int cartId;
        private int quantity;
    }
}
