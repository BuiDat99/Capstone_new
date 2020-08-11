package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.ResourceCategory;

public interface ResourceCategoryRepository extends JpaRepository<ResourceCategory, Integer> {

}
