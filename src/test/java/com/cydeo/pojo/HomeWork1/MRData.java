package com.cydeo.pojo.HomeWork1;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "xmlns",
        "series",
        "url",
        "limit",
        "offset",
        "total",
        "DriverTable"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MRData {
    @JsonProperty("xmlns")
    public String xmlns;
    @JsonProperty("series")
    public String series;
    @JsonProperty("url")
    public String url;
    @JsonProperty("limit")
    public String limit;
    @JsonProperty("offset")
    public String offset;
    @JsonProperty("total")
    public String total;
    @JsonProperty("DriverTable")
    public DriverTable driverTable;


}
