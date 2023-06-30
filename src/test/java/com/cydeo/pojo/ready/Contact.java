
package com.cydeo.pojo.ready;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "contactId",
    "phone",
    "emailAddress",
    "permanentAddress"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    @JsonProperty("contactId")
    public Integer contactId;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("emailAddress")
    public String emailAddress;
    @JsonProperty("permanentAddress")
    public String permanentAddress;

}
