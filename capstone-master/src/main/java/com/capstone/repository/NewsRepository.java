package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}
