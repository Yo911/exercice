package com.exercice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Product {
    String name;
    String quality;
    long price;
    @Builder.Default
    String currency = "EUR";
}
