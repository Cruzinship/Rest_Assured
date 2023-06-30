package com.cydeo.pojo.HomeWork1;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MRData"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Example {
    @JsonProperty("MRData")
    public MRData mRData;

}

