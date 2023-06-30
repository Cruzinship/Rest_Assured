package com.cydeo.pojo.HomeWork1;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "driverId",
        "Drivers"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DriverTable {
    @JsonProperty("driverId")
    public String driverId;
    @JsonProperty("Drivers")
    public List<Driver> drivers;

}
