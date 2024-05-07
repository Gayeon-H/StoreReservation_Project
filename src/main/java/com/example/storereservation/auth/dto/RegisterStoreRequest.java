package com.example.storereservation.auth.dto;

import com.example.storereservation.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStoreRequest extends RegisterRequest {

    private String businessNumber;
    private String address;
    private double latitude;
    private double longitude;
    private String contents;

    public Store convertToStore(Long memberId) {
        return Store.builder()
                .storeId(memberId)
                .businessNumber(businessNumber)
                .address(address)
                .latitude(latitude)
                .longitude(longitude)
                .contents(contents)
                .regDate(LocalDateTime.now())
                .build();
    }

}
