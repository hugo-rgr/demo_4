package com.example.demo.catalog.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion createPromotion(Promotion id) {
        return promotionRepository.save(id);
    }

    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion updatePromotion(Long id, Promotion promotionDetails) {
        Optional<Promotion> promotion = promotionRepository.findById(id);
        if (promotion.isPresent()) {
            Promotion existingPromotion = promotion.get();
            existingPromotion.setStartDate(promotionDetails.getStartDate());
            existingPromotion.setEndDate(promotionDetails.getEndDate());
            existingPromotion.setDiscountPercentage(promotionDetails.getDiscountPercentage());
            return promotionRepository.save(existingPromotion);
        }
        return null;
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    public void deleteAllPromotionsByIds(Set<Long> ids){ promotionRepository.deleteAllById(ids);}

    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }
}
