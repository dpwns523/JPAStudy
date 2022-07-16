package com.example.jpastudy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class Member {
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @RequiredArgsConstructor
    public static class JoinMemberRequest{
        private String name;
        private String city;
        private String street;
        private String zipcode;
    }
    @Data
    public static class JoinMemberResponse{
        private Long id;
        public JoinMemberResponse(Long id){
            this.id=id;
        }
    }
}
