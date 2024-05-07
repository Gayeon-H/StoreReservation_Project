package com.example.storereservation.store.service;

import com.example.storereservation.auth.dto.RegisterStoreRequest;
import com.example.storereservation.store.entity.Store;

public interface StoreService {

    Store registerStore(Long memberId, RegisterStoreRequest request);

}
