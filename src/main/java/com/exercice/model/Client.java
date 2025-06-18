package com.exercice.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Client implements IClient {
    @NotNull
    String id;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @Builder.Default
    List<Product> shoppingCart = new ArrayList<>();

    @Override
    public ClientType getClientType() {
        return ClientType.PARTICULAR;
    }
}
