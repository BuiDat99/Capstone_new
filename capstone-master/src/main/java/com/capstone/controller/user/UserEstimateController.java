package com.capstone.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResource2Dto;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.Resource2Dto;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.repository.ProductRepository;
import com.capstone.repository.ProductResourceRepository;
import com.capstone.repository.ResourceRepository;
import com.capstone.service.ProductResourceService;
import com.capstone.service.ProductService;
import com.capstone.service.ResourceCategoryService;
import com.capstone.service.ResourceService;
import com.capstone.utils.ImgurUtil;

@Controller
public class UserEstimateController {
	@Autowired
	private ResourceCategoryService categoryService;
	@Autowired
	private ResourceService resourceService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductResourceService prService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ImgurUtil imgurUtil;

	@Autowired
	private ProductResourceRepository productResourceRepository;

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private ProductResourceService productResourceService;

	@RequestMapping(value = "/user/estimate", method = RequestMethod.GET)
	public String ResetPass(Model model, HttpServletRequest request) {
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories("1");
		request.setAttribute("categoryList", categoryList);
		return "user/estimatedCalories";
	}

	@PostMapping(value = "/user/product/add-product")
	public @ResponseBody int addProductPost(HttpServletRequest request,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "productDescription", required = false) String productDescription,
			@RequestParam(value = "image", required = false) MultipartFile file) {
		Product p = new Product();
		p.setProductName(productName);
		p.setProductDescription(productDescription);
		p.setImage(imgurUtil.uploadImage(file));
		p = productRepository.save(p);

		return p.getId();
	}

	@PostMapping(value = "/user/product/add-resources-to-product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain;charset=UTF-8")
	public String addResourceToProduct(HttpServletRequest request,
			@RequestBody ProductResource2Dto ProductResource2Dto) {
		List<ProductDTO> listProduct = productService.getAllProducts("1");
		request.setAttribute("listProduct", listProduct);
		List<ProductResourceDTO> listPr = prService.getAllProductResource();
		request.setAttribute("listPr", listPr);

		Product p = productRepository.findById(ProductResource2Dto.getProductId()).get();
		for (Resource2Dto r : ProductResource2Dto.getResources()) {
			Resource res = resourceRepository.findById(r.getId()).get();
			ProductResource prodResource = new ProductResource();
			prodResource.setResource(res);
			prodResource.setProduct(p);
			prodResource.setKcal1g(r.getGram());
			productResourceRepository.save(prodResource);
		}
		return "admin/product/manage-product";
	}

	@GetMapping(value = "/user/resource/resourceCat/{id}")
	public @ResponseBody List<ResourceDTO> getResourceFromResouceCategory(@PathVariable("id") int id) {
		return resourceService.getResourceFromWithResouceCatId(id);
	}
}
