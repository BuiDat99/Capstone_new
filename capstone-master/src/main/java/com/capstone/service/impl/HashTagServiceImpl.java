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
		hashtagDao.addTag(h);
		
	}

	@Override
	public HashTagDTO getTagbyId(int id) {
		HashtagStandard tag = hashtagDao.getTagbyId(id);
		HashTagDTO dto = new HashTagDTO();
		dto.setTagId(tag.getTagId());
		dto.setTagCode(tag.getTagCode());
		dto.setTagContent(tag.getTagContent());
		
		return dto;
	}
	
	@Override
	public void updateTag(HashTagDTO tagDTO) {
		HashtagStandard tag = hashtagDao.getTagbyId(tagDTO.getTagId());
		if(tag != null) {
			tag.setTagCode(tagDTO.getTagCode());
			tag.setTagContent(tagDTO.getTagContent());			
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
	public List<HashTagDTO> getAllTags() {
		List<HashtagStandard> tags = hashtagDao.getAllTags();
		List<HashTagDTO> dtos = new ArrayList<HashTagDTO>();
		for(HashtagStandard h: tags) {
			HashTagDTO dto = new HashTagDTO();
			dto.setTagId(h.getTagId());
			dto.setTagCode(h.getTagCode());
			dto.setTagContent(h.getTagContent());
			
			dtos.add(dto);
		}
		return dtos;
	}
		

	@Override
	public List<HashTagDTO> search(String name, int start, int length) {
		List<HashtagStandard> tags = hashtagDao.search(name, start, length);
		List<HashTagDTO> dtos = new ArrayList<HashTagDTO>();
		for(HashtagStandard h: tags) {
			HashTagDTO dto = new HashTagDTO();
			dto.setTagId(h.getTagId());
			dto.setTagCode(h.getTagCode());
			dto.setTagContent(h.getTagContent());
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int countTagWhensearch(String name) {		
		return hashtagDao.countTagWhensearch(name);
	}

	

}
