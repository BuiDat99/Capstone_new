package com.capstone.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.UserHistoryDao;
import com.capstone.entity.AppUser;
import com.capstone.entity.UserHistory;
import com.capstone.model.AppUserDTO;
import com.capstone.model.UserHistoryDTO;

public interface UserHistoryService {
	void add(UserHistoryDTO historyDTO);

	void update(UserHistoryDTO userHistoryDTO);

	void delete(int id);

	UserHistoryDTO getUserHistory(int id);

	List<UserHistoryDTO> searchUserHistory(int id);
}

@Transactional
@Service
class UserHistoryServiceImpl implements UserHistoryService {
	@Autowired
	private UserHistoryDao userHistoryDao;

	@Override
	public void add(UserHistoryDTO historyDTO) {
		UserHistory userHistory = new UserHistory();
		userHistory.setHeight(historyDTO.getHeight());
		userHistory.setWeight(historyDTO.getWeight());
		AppUser appUser = new AppUser();
		appUser.setUserId(historyDTO.getAppUser().getUserId());
		userHistory.setAppUser(appUser);
		userHistory.setBmi(historyDTO.getBmi());
		userHistory.setCreation_Date(historyDTO.getCreation_Date());
		userHistory.setDesire(historyDTO.getDesire());
		userHistory.setTrack_Results(historyDTO.getTrack_Results());
		userHistoryDao.add(userHistory);
		historyDTO.setId(userHistory.getId());
	}

	@Override
	public void update(UserHistoryDTO userHistoryDTO) {
		UserHistory userHistory = userHistoryDao.getUserHistory(userHistoryDTO.getId());
		if (userHistory != null) {
			userHistory.setHeight(userHistoryDTO.getHeight());
			userHistory.setWeight(userHistoryDTO.getWeight());
			AppUser appUser = new AppUser();
			appUser.setUserId(userHistoryDTO.getAppUser().getUserId());
			userHistory.setAppUser(appUser);
			userHistory.setBmi(userHistoryDTO.getBmi());
			userHistory.setCreation_Date(userHistoryDTO.getCreation_Date());
			userHistory.setDesire(userHistoryDTO.getDesire());
			userHistory.setTrack_Results(userHistoryDTO.getTrack_Results());
			userHistoryDao.update(userHistory);
		}
	}

	@Override
	public void delete(int id) {
		UserHistory userHistory = userHistoryDao.getUserHistory(id);
		if (userHistory != null) {
			userHistoryDao.delete(userHistory);
		}
	}

	@Override
	public UserHistoryDTO getUserHistory(int id) {
		UserHistory userHistory = userHistoryDao.getUserHistory(id);
		UserHistoryDTO userHistoryDTO= new UserHistoryDTO();
		userHistoryDTO.setHeight(userHistory.getHeight());
		userHistoryDTO.setWeight(userHistory.getWeight());
		AppUserDTO appUserDTO = new AppUserDTO();
		appUserDTO.setUserId(userHistory.getAppUser().getUserId());
		userHistoryDTO.setAppUser(appUserDTO);
		userHistoryDTO.setBmi(userHistory.getBmi());
		userHistoryDTO.setCreation_Date(userHistory.getCreation_Date());
		userHistoryDTO.setDesire(userHistory.getDesire());
		userHistoryDTO.setTrack_Results(userHistory.getTrack_Results());
		return userHistoryDTO;
	}

	@Override
	public List<UserHistoryDTO> searchUserHistory(int id) {
		List<UserHistoryDTO> historyDTOs= new  ArrayList<UserHistoryDTO>();
		List<UserHistory> histories= userHistoryDao.searchUserHistory(id);
		for(UserHistory history: histories) {
			UserHistoryDTO userHistoryDTO= new UserHistoryDTO();
			userHistoryDTO.setHeight(history.getHeight());
			userHistoryDTO.setWeight(history.getWeight());
			AppUserDTO appUserDTO = new AppUserDTO();
			appUserDTO.setUserId(history.getAppUser().getUserId());
			userHistoryDTO.setAppUser(appUserDTO);
			userHistoryDTO.setBmi(history.getBmi());
			userHistoryDTO.setCreation_Date(history.getCreation_Date());
			userHistoryDTO.setDesire(history.getDesire());
			userHistoryDTO.setTrack_Results(history.getTrack_Results());
			historyDTOs.add(userHistoryDTO);
		}
		return historyDTOs;
	}

}