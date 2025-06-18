package com.exercice.service;

import com.exercice.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingServiceTest {

    private ShoppingService shoppingService;

    private final static Product HIGH_QUALITY_SMART_PHONE = Product.builder()
            .name("téléphone haut de gamme")
            .price(Map.of(
                    ClientType.PARTICULAR, 1500L,
                    ClientType.PRO, 1150L,
                    ClientType.PRO_VIP, 1000L
            ))
            .build();
    private final static Product MIDDLE_QUALITY_SMART_PHONE = Product.builder()
            .name("téléphone milieu de gamme")
            .price(Map.of(
                    ClientType.PARTICULAR, 800L,
                    ClientType.PRO, 600L,
                    ClientType.PRO_VIP, 550L
            ))
            .build();
    private final static Product LAPTOP = Product.builder()
            .name("laptop")
            .price(Map.of(
                    ClientType.PARTICULAR, 1200L,
                    ClientType.PRO, 1000L,
                    ClientType.PRO_VIP, 900L
            ))
            .build();

    @BeforeEach
    void setUp() {
        shoppingService = new ShoppingService();
    }

    @Test
    void should_get_total_price_for_particular_client() {
        IClient client = Client.builder()
                .id(UUID.randomUUID().toString())
                .lastName("arn")
                .firstName("yeh")
                .shoppingCart(
                        List.of(HIGH_QUALITY_SMART_PHONE, MIDDLE_QUALITY_SMART_PHONE, LAPTOP)
                )
                .build();


        Long total = shoppingService.totalPriceShoppingCart(client);

        assertThat(total).isNotNull().isEqualTo(1200 + 800 + 1500L);
    }

    @Test
    void should_get_total_price_for_profesionnal_client() {
        IClient client = ClientProfessional.builder()
                .id(UUID.randomUUID().toString())
                .tva("FR-TVA")
                .annualTurnover(10_000L)
                .siren("SIREN")
                .companyName("Company")
                .shoppingCart(
                        List.of(HIGH_QUALITY_SMART_PHONE, MIDDLE_QUALITY_SMART_PHONE, LAPTOP)
                )
                .build();


        Long total = shoppingService.totalPriceShoppingCart(client);

        assertThat(total).isNotNull().isEqualTo(1150L + 600L + 1000L);
    }

    @Test
    void should_get_total_price_for_profesionnal_client_vip() {
        IClient client = ClientProfessional.builder()
                .id(UUID.randomUUID().toString())
                .tva("FR-TVA")
                .annualTurnover(100_000_000L)
                .siren("SIREN")
                .companyName("Company")
                .shoppingCart(
                        List.of(HIGH_QUALITY_SMART_PHONE, MIDDLE_QUALITY_SMART_PHONE, LAPTOP)
                )
                .build();


        Long total = shoppingService.totalPriceShoppingCart(client);

        assertThat(total).isNotNull().isEqualTo(1000L + 550L + 900L);
    }

}