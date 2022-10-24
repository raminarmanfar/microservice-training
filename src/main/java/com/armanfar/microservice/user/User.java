package com.armanfar.microservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@JsonIgnoreProperties({"name", "birthdate"})
@JsonFilter("DynamicUserBeanFilter")
public class User {
    private Integer id;

    //@JsonIgnore
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past(message = "birthdate should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthdate;
}
