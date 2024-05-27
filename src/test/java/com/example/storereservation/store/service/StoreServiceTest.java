package com.example.storereservation.store.service;

import com.example.storereservation.auth.dto.RegisterStoreRequest;
import com.example.storereservation.store.entity.Store;
import com.example.storereservation.store.repository.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {

    @InjectMocks
    private StoreServiceImpl storeService;
    @Mock
    private StoreRepository storeRepository;

    @DisplayName("매장 등록")
    @Test
    void registerStore() {
        // given
        RegisterStoreRequest request = registerStoreRequest();
        Long memberId = 2L;
        Store store = request.convertToStore(memberId);
        when(storeRepository.save(any(Store.class))).thenReturn(store);

        // when
        Store result = storeService.registerStore(memberId, request);

        // then
        assertEquals(result.getBusinessNumber(), store.getBusinessNumber());
        assertEquals(result.getStarRating(), 0.0);
        verify(storeRepository, times(1)).save(any(Store.class));
    }

    private RegisterStoreRequest registerStoreRequest() {
        return RegisterStoreRequest.builder()
                .name("매장")
                .userId("storeId")
                .password("storeId")
                .phone("010-1234-1233")
                .address("서울시 강남구")
                .latitude(37.3423)
                .longitude(127.2345)
                .businessNumber("2312-231-12324")
                .contents("open 10시, close 22시")
                .build();
    }

}