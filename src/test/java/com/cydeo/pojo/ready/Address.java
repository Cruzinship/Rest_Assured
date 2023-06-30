package com.cydeo.pojo.ready;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "addressId",
        "street",
        "city",
        "state",
        "zipCode"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {


    @JsonProperty("addressId")
    public Integer addressId;
    @JsonProperty("street")
    public String street;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("zipCode")
    public Integer zipCode;
}

