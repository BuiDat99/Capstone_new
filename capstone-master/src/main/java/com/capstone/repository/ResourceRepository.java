package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
