package com.exercice.model;

public interface IClient {
    String getId();

    default boolean isProfessional() {
        return false;
    }

    default boolean isOverTenMillions() {
        return false;
    }
}
