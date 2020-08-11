package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
