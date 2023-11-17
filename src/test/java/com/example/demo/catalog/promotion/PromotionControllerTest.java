package com.example.demo.catalog.promotion;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class PromotionControllerTest {

    @Mock
    private PromotionService promotionService;

    @InjectMocks
    private PromotionController promotionController;

    public PromotionControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePromotion() {
        Promotion promotion = new Promotion();
        promotion.setDiscountPercentage(10);
        promotion.setStartDate(LocalDate.parse("2023-01-01"));
        promotion.setEndDate(LocalDate.parse("2023-01-31"));

        when(promotionService.createPromotion(any(Promotion.class))).thenReturn(promotion);

        Promotion response = promotionController.createPromotion(promotion);

        verify(promotionService, times(1)).createPromotion(any(Promotion.class));
    }
}

