package com.exercice.service;

import com.exercice.model.ClientType;
import com.exercice.model.IClient;
import com.exercice.model.Product;

import java.util.Objects;

public class ShoppingService {

    public Long totalPriceShoppingCart(IClient client) {
        ClientType clientType = client.getClientType();

        return client.getShoppingCart().stream()
                .map(Product::getPrice)
                .filter(Objects::nonNull)
                .map(price -> price.getOrDefault(clientType, 0L))
                .reduce(0L, Long::sum);
    }

}
