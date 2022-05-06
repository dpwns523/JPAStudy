package com.example.jpastudy.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
