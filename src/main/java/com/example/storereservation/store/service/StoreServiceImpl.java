package com.example.storereservation.store.service;

import com.example.storereservation.auth.dto.RegisterStoreRequest;
import com.example.storereservation.store.entity.Store;
import com.example.storereservation.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store registerStore(Long memberId, RegisterStoreRequest request) {
        Store store = request.convertToStore(memberId);

        return storeRepository.save(store);
    }

}
