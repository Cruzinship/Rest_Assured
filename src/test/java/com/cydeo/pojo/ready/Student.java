
package com.cydeo.pojo.ready;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "studentId",
    "firstName",
    "lastName",
    "batch",
    "joinDate",
    "birthDate",
    "password",
    "subject",
    "gender",
    "admissionNo",
    "major",
    "section",
    "contact",
    "company"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @JsonProperty("studentId")
    public Integer studentId;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("batch")
    public Integer batch;
    @JsonProperty("joinDate")
    public String joinDate;
    @JsonProperty("birthDate")
    public String birthDate;
    @JsonProperty("password")
    public String password;
    @JsonProperty("subject")
    public String subject;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("admissionNo")
    public String admissionNo;
    @JsonProperty("major")
    public String major;
    @JsonProperty("section")
    public String section;
    @JsonProperty("contact")
    public Contact contact;
    @JsonProperty("company")
    public Company company;
}
