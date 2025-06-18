package com.exercice.service;

import com.exercice.model.Client;
import com.exercice.model.ClientType;
import com.exercice.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingServiceTest {

    private ShoppingService shoppingService;

    @BeforeEach
    void setUp() {
        shoppingService = new ShoppingService();
    }

    @Test
    void should_get_total_price_for_particular_client() {
        Product highQualitySmartPhone = Product.builder()
                .name("téléphone haut de gamme")
                .price(Map.of(
                        ClientType.PARTICULAR, 1500L,
                        ClientType.PRO, 1150L,
                        ClientType.PRO_VIP, 1000L
                ))
                .build();
        Product middleQualitySmartPhone = Product.builder()
                .name("téléphone milieu de gamme")
                .price(Map.of(
                        ClientType.PARTICULAR, 800L,
                        ClientType.PRO, 600L,
                        ClientType.PRO_VIP, 550L
                ))
                .build();
        Product laptop = Product.builder()
                .name("laptop")
                .price(Map.of(
                        ClientType.PARTICULAR, 1200L,
                        ClientType.PRO, 1000L,
                        ClientType.PRO_VIP, 900L
                ))
                .build();

        Client client = Client.builder()
                .id(UUID.randomUUID().toString())
                .lastName("arn")
                .firstName("yeh")
                .shoppingCart(
                        List.of(highQualitySmartPhone, middleQualitySmartPhone, laptop)
                )
                .build();


        Long total = shoppingService.totalPriceShoppingCart(client);

        assertThat(total).isNotNull().isEqualTo(1200 + 800 + 1500L);
    }

}