
package com.cydeo.pojo.ready;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "companyId",
    "companyName",
    "title",
    "startDate",
    "address"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    @JsonProperty("companyId")
    public Integer companyId;
    @JsonProperty("companyName")
    public String companyName;
    @JsonProperty("title")
    public String title;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("address")
    public Address address;
}
