package com.example.storereservation.store.service;

import com.example.storereservation.auth.dto.RegisterStoreRequest;

public interface StoreService {

    void registerStore(Long memberId, RegisterStoreRequest request);

}
