package com.example.storereservation.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    private Long storeId;
    private String businessNumber;
    private String address;
    private double latitude;
    private double longitude;
    @Builder.Default
    private double starRating = 0.0;
    private String contents;

}
