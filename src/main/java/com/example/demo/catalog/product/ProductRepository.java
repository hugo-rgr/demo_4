package com.example.demo.catalog.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.label = :categoryLabel")
    List<Product> findByCategoryLabel(String categoryLabel);

    //@Query("UPDATE p FROM Product p JOIN p.category c WHERE c.label = :categoryLabel")
    //List<Product> updateProduct(String );

    //méthode pour appeler prendre catégorie par id produit



    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.category.id = :categoryId")
    void deleteByCategoryLabel(Long categoryId);
}
