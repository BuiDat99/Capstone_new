package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.ProductResource;

public interface ProductResourceRepository extends JpaRepository<ProductResource, Integer> {

}
