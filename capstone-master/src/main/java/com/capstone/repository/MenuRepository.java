package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
