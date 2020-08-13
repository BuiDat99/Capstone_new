package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.HashtagDAO;
import com.capstone.entity.HashtagStandard;
import com.capstone.model.HashTagDTO;
import com.capstone.service.HashTagService;

@Service
@Transactional
public class HashTagServiceImpl implements HashTagService {

	@Autowired
	private HashtagDAO hashtagDao;
	@Override
	public void addTag(HashTagDTO tag) {
		HashtagStandard h = new HashtagStandard();
		h.setTagCode(tag.getTagCode());
		h.setTagContent(tag.getTagContent());
		h.setEnable("1");
		hashtagDao.addTag(h);
		
	}

	@Override
	public HashTagDTO getTagbyId(int id) {
		HashtagStandard tag = hashtagDao.getTagbyId(id);
		HashTagDTO dto = new HashTagDTO();
		dto.setTagId(tag.getTagId());
		dto.setTagCode(tag.getTagCode());
		dto.setTagContent(tag.getTagContent());
		dto.setEnable(tag.getEnable());
		return dto;
	}
	
	@Override
	public void updateTag(HashTagDTO tagDTO) {
		HashtagStandard tag = hashtagDao.getTagbyId(tagDTO.getTagId());
		if(tag != null) {
			tag.setTagCode(tagDTO.getTagCode());
			tag.setTagContent(tagDTO.getTagContent());	
			tag.setEnable(tagDTO.getEnable());
			hashtagDao.updateTag(tag);
		}		
		
	}

	@Override
	public void deleteTag(int id) {
		HashtagStandard tag = hashtagDao.getTagbyId(id);
		if(tag != null) {
			hashtagDao.deleteTag(tag);
		}
		
	}

	@Override
	public List<HashTagDTO> getAllTags(String enable) {
		List<HashtagStandard> tags = hashtagDao.getAllTags(enable);
		List<HashTagDTO> dtos = new ArrayList<HashTagDTO>();
		for(HashtagStandard h: tags) {
			HashTagDTO dto = new HashTagDTO();
			dto.setTagId(h.getTagId());
			dto.setTagCode(h.getTagCode());
			dto.setTagContent(h.getTagContent());
			dto.setEnable(h.getEnable());
			dtos.add(dto);
		}
		return dtos;
	}
		

	@Override
	public List<HashTagDTO> search(String enable,String name, int start, int length) {
		List<HashtagStandard> tags = hashtagDao.search(enable,name, start, length);
		List<HashTagDTO> dtos = new ArrayList<HashTagDTO>();
		for(HashtagStandard h: tags) {
			HashTagDTO dto = new HashTagDTO();
			dto.setTagId(h.getTagId());
			dto.setTagCode(h.getTagCode());
			dto.setTagContent(h.getTagContent());
			dto.setEnable(h.getEnable());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int countTagWhensearch(String enable,String name) {		
		return hashtagDao.countTagWhensearch(enable,name);
	}

	

}
