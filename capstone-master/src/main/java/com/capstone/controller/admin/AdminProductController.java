package com.capstone.controller.admin;

import java.beans.PropertyEditor;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;
import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResource2Dto;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.Resource2Dto;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.repository.ProductRepository;
import com.capstone.repository.ProductResourceRepository;
import com.capstone.repository.ResourceRepository;
import com.capstone.service.ProductResourceService;
import com.capstone.service.ProductService;
import com.capstone.service.ResourceCategoryService;
import com.capstone.utils.DuplicateParameterReducingPropertyEditor;
import com.capstone.utils.ImgurUtil;

@Controller
public class AdminProductController {

	@Autowired
	private AppUserDAO appUserService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductResourceService prService;

	@Autowired
	private ResourceCategoryService categoryService;

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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		PropertyEditor stringEditor = new DuplicateParameterReducingPropertyEditor();
		binder.registerCustomEditor(String.class, stringEditor);
	}

	@GetMapping(value = "/admin/product/search")
	public String searchProduct(HttpServletRequest request) {

		List<ProductDTO> listProduct = productService.getAllProducts("");
		for (ProductDTO pdto : listProduct) {
			Product p = productRepository.findById(pdto.getId()).get();
			System.out.println(p.getId());
			List<String> resources = new ArrayList<>();
			List<ProductResource> rlist = productResourceRepository.findAll();
			for (ProductResource pr : rlist) {
				if (pr.getProduct().getId() == p.getId()) {
					resources.add(pr.getResource().getResourceName());
				}
			}
			pdto.setResources(resources);
		}
		request.setAttribute("listProduct", listProduct);
		return "admin/product/manage-product";
	}

	@GetMapping(value = "/admin/product/add-product")
	public String addProduct(HttpServletRequest request) {
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories("1");
		request.setAttribute("categoryList", categoryList);
		return "admin/product/add-product";
	}

	@PostMapping(value = "/admin/product/add-product")
	public @ResponseBody int addProductPost(HttpServletRequest request,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "productDescription", required = false) String productDescription,
			@RequestParam(value = "image", required = false) MultipartFile file, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserService.findAppUserbyUserName(loginedUser.getUsername());
		Product p = new Product();
		p.setProductName(productName);
		p.setProductDescription(productDescription);
		p.setImage(imgurUtil.uploadImage(file));
		p.setUser(user);
		p.setEnable("1");
		p = productRepository.save(p);

		return p.getId();
	}

	@GetMapping(value = "/admin/product/edit-product")
	public String editProduct(HttpServletRequest request, @RequestParam(name = "id") int id, Model model) {
		ProductDTO productDTO = productService.getProductbyId(id);
		model.addAttribute("productDTO", productDTO);
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories("1");
		request.setAttribute("categoryList", categoryList);
		return "admin/product/edit-product";
	}

	@GetMapping(value = "/admin/product/mokhoa")
	public String editmokhoaProduct(@RequestParam(name = "id") int id) {
		ProductDTO productDTO = productService.getProductbyId(id);
		productDTO.setEnable("1");
		productService.updateProduct(productDTO);
		return "redirect:/admin/product/search";
	}

	@GetMapping(value = "/admin/product/khoa")
	public String editkhoaProduct(@RequestParam(name = "id") int id) {
		ProductDTO productDTO = productService.getProductbyId(id);
		productDTO.setEnable("0");
		productService.updateProduct(productDTO);
		return "redirect:/admin/product/search";
	}

	@PostMapping(value = "/admin/product/edit-product")
	public @ResponseBody void editProductPost(HttpServletRequest request,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "productDescription", required = false) String productDescription,
			@RequestParam(value = "image", required = false) MultipartFile file, @RequestParam(value = "id") int id) {

		ProductDTO p = productService.getProductbyId(id);
		p.setProductName(productName);
		p.setProductDescription(productDescription);
		String image = imgurUtil.uploadImage(file);
		if (image != null) {
			p.setImage(image);
		}

		productService.updateProduct(p);
		List<ProductResourceDTO> productResourceDTOs = productResourceService.getProductResourceByProductId(id);
		for (ProductResourceDTO productResourceDTO : productResourceDTOs) {
			productResourceService.deleteProductResource(productResourceDTO.getId());
		}

	}

	@PostMapping(value = "/admin/product/add-resources-to-product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain;charset=UTF-8")
	public String addResourceToProduct(HttpServletRequest request,
			@RequestBody ProductResource2Dto ProductResource2Dto) {
		List<ProductDTO> listProduct = productService.getAllProducts("");
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

	@PostMapping(value = "/admin/product/edit-resources-to-product")
	@ResponseBody
	public void editResourceToProduct(HttpServletRequest request,
			@RequestBody ProductResource2Dto ProductResource2Dto) {
//		List<ProductResourceDTO> productResourceDTOs= productResourceService.getProductResourceByProductId(productResourceDto.getProductId());
		ProductDTO productDTO = productService.getProductbyId(ProductResource2Dto.getProductId());
		Product product = new Product();
		product.setId(productDTO.getId());
		for (Resource2Dto r : ProductResource2Dto.getResources()) {
			Resource res = resourceRepository.findById(r.getId()).get();
			ProductResource prodResource = new ProductResource();
			prodResource.setResource(res);
			prodResource.setProduct(product);
			prodResource.setKcal1g(r.getGram());
			productResourceRepository.save(prodResource);
		}
	}

	@GetMapping(value = "/admin/product/delete")
	public String deleteProduct(int id) {
		prService.deleteProductResource(id);
		productRepository.deleteById(id);

		return "redirect:/admin/product/search";
	}
}
