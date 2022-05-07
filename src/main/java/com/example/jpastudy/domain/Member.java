package com.example.jpastudy.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {

    private String name;
    private String city;
    private String street;
    private String zipcode;

}
