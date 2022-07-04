package com.example.jpastudy.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {

    private String name;
    private String city;
    private String street;
    private String zipcode;

    private List<Orders> orders = new ArrayList<Orders>();

}
