package com.capstone;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.controller.admin.AdminMenuController;
import com.capstone.model.ProductDTO;
import com.capstone.service.ProductService;

@SpringBootTest
class HeathyLifeApplicationTests {

	@Test
	void GetAllProductsOfMenu () {
		// Generate Controller
		AdminMenuController adminMenuMock = new AdminMenuController();
		// Mục đích của mockito là Run UnitTest cho hàm trong class định test(controller) 
		// nhưng ko phụ thuộc, ràng buộc bởi class khác như Service(Tức là ko run vào service để call dao)
		// Mock Service because this service don't have controller
		ProductService productService = mock(ProductService.class);
		
		//  Tạo Data return
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		ProductDTO productDTO = new ProductDTO(1, "Dat", "Dat");
		ProductDTO productDTO1 = new ProductDTO(16, "Dat", "Dat");
		productDTOs.add(productDTO);
		productDTOs.add(productDTO1);
		// Way to mock function getAllProducts in service and return data mock
		when(productService.getAllProducts("1")).thenReturn(productDTOs);
		adminMenuMock.setProductService(productService);
		String productName =  adminMenuMock.getAllProduct().get(0).getProductName();
		Assertions.assertEquals("Dat",productName);
		//adminMenuMock.getAllProduct() null
	}

}
