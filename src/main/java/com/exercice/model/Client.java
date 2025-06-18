package com.exercice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Client implements IClient {
    String id;
    String firstName;
    String lastName;
}
