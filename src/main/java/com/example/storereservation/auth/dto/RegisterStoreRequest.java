package com.example.storereservation.auth.dto;

import com.example.storereservation.common.validator.BusinessNumber;
import com.example.storereservation.common.validator.Latitude;
import com.example.storereservation.common.validator.Longitude;
import com.example.storereservation.store.entity.Store;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStoreRequest extends RegisterRequest {

    @BusinessNumber
    private String businessNumber;
    @NotBlank(message = "주소를 기입해주세요.")
    private String address;
    @Latitude
    private Double latitude;
    @Longitude
    private Double longitude;
    private String contents;

    public Store convertToStore(Long memberId) {
        return Store.builder()
                .storeId(memberId)
                .businessNumber(businessNumber)
                .address(address)
                .latitude(latitude)
                .longitude(longitude)
                .contents(contents)
                .build();
    }

}
