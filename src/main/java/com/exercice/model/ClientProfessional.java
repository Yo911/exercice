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
public class ClientProfessional implements IClient {
    public static final long TEN_MILLIONS_ANNUAL_TURNOVER = 10_000_000L;
    @NotNull
    String id;
    @NotNull
    String companyName;
    String tva;
    @NotNull
    String siren;
    @NotNull
    Long annualTurnover; // à voir pour un BigDecimal
    @Builder.Default
    List<Product> shoppingCart = new ArrayList<>();

    @Override
    public boolean isProfessional() {
        return true;
    }

    @Override
    public boolean isOverTenMillions() {
        return annualTurnover != null && TEN_MILLIONS_ANNUAL_TURNOVER <= annualTurnover;
    }

    @Override
    public ClientType getClientType() {
        return isOverTenMillions() ?
                ClientType.PRO_VIP:
                ClientType.PRO;
    }
}
