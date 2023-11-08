package com.example.EcommerceProductService.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcommerceProductService.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
