package com.fngeno.webclientdemo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import reactor.util.annotation.Nullable;


public interface Employee {
    @JsonProperty("age")
    int getAge();

    @JsonProperty("id")
    Integer getId();

    @JsonProperty("firstName")
    @Nullable
    String getFirstName();
    
    @JsonProperty("lastName")
    @Nullable
    String getLastName();

    @JsonProperty("gender")
    @Nullable
    String getGender();

    @JsonProperty("role")
    @Nullable
    String getRole();
}
