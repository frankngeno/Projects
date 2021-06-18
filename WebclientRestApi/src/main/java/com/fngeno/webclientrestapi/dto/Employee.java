package com.fngeno.webclientrestapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import reactor.util.annotation.Nullable;

@Value.Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = ImmutableEmployee.Builder.class)
public interface Employee {
    @JsonProperty("age")
    Integer getAge();

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
