package com.exercice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Map;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Product {
    String name;
    Map<ClientType, Long> price;
    @Builder.Default
    String currency = "EUR";
}
