package com.exercice.model;

import java.util.List;

public interface IClient {
    String getId();

    ClientType getClientType();

    List<Product> getShoppingCart();

    default boolean isProfessional() {
        return false;
    }

    default boolean isOverTenMillions() {
        return false;
    }
}
