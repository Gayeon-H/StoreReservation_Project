package com.example.storereservation.member.dto;

import lombok.Getter;

@Getter
public class JoinStoreDto extends JoinDto {

    private String address;
    private Double latitude;
    private Double longitude;
    private String contents;
    private String businessNumber;

}
