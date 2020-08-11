package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Integer> {

}
