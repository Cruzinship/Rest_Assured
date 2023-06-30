package com.cydeo.pojo.HomeWork1;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "driverId",
        "permanentNumber",
        "code",
        "url",
        "givenName",
        "familyName",
        "dateOfBirth",
        "nationality"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Driver {

    @JsonProperty("driverId")
    public String driverId;
    @JsonProperty("permanentNumber")
    public String permanentNumber;
    @JsonProperty("code")
    public String code;
    @JsonProperty("url")
    public String url;
    @JsonProperty("givenName")
    public String givenName;
    @JsonProperty("familyName")
    public String familyName;
    @JsonProperty("dateOfBirth")
    public String dateOfBirth;
    @JsonProperty("nationality")
    public String nationality;

}
