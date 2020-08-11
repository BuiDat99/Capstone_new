package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	AppUser findByEmail(String email);
	Boolean existsByEmail(String email);
}
