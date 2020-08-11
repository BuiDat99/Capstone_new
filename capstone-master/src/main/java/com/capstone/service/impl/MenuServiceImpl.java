package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.MenuDAO;
import com.capstone.entity.Menu;
import com.capstone.model.MenuDTO;
import com.capstone.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDao;
	@Override
	public void addMenu(MenuDTO menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMenu(MenuDTO menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMenu(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MenuDTO> getAllMenu() {
		List<Menu> ms = menuDao.getAllMenu();
		List<MenuDTO> dtos = new ArrayList<MenuDTO>();
		for(Menu m:ms) {
			MenuDTO dto = new MenuDTO();
			dto.setId(m.getId());
			dto.setHashtag(m.getHashtag());
			dto.setMenuName(m.getMenuName());
// thieu set role
//			dto.setRole(m.getRole().getRoleId());
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public MenuDTO getMenubyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
