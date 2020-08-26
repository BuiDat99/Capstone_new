package com.capstone;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.model.HashTagDTO;
import com.capstone.service.HashTagService;

@SpringBootTest
class HeathyLifeApplicationTests {

	@Autowired
	private HashTagService tagService;
	@Test
	void contextLoads() {
		List<HashTagDTO> tagList = tagService.search("","", 1*7, 7);	
		Assertions.assertNotNull(tagService);
		Assertions.assertNotNull(tagList);
		
		
	}

}
