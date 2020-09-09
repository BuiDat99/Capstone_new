package com.capstone.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;
import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.AppUserDTO;
import com.capstone.model.HashTagDTO;
import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResource2Dto;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.Resource2Dto;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.repository.ProductRepository;
import com.capstone.repository.ProductResourceRepository;
import com.capstone.repository.ResourceRepository;
import com.capstone.service.HashTagService;
import com.capstone.service.NewCategoryService;
import com.capstone.service.NewsService;
import com.capstone.service.ProductResourceService;
import com.capstone.service.ProductService;
import com.capstone.service.ResourceCategoryService;
import com.capstone.service.ResourceService;
import com.capstone.utils.ImgurUtil;

@Controller
public class UserEstimateController {
	@Autowired
	private AppUserDAO appUserService;
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
	
	@Autowired
	private NewCategoryService newCatService;

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private HashTagService hashtagService;
	
	@GetMapping(value = "/user/product/search")
	public String searchProduct(HttpServletRequest request,Principal principal,
			@RequestParam(name = "catId") Optional<Integer> catId, HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserService.findAppUserbyUserName(loginedUser.getUsername());
		List<ProductDTO> listProduct = productService.getAllProductsByUser("", user.getUserId());
		for (ProductDTO pdto : listProduct) {
			Product p = productRepository.findById(pdto.getId()).get();
			System.out.println(p.getId());
			List<String> resources = new ArrayList<>();
			List<ProductResource> rlist = productResourceRepository.findAll();
			for (ProductResource pr: rlist) {
				if (pr.getProduct().getId() == p.getId()) {
					resources.add(pr.getResource().getResourceName());
				}
			}
			pdto.setResources(resources);
		}
		request.setAttribute("listProduct", listProduct);
		
		// filter

		request.setAttribute("hashtag", has);
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		return "user/edit/manage_product";
	}

	@RequestMapping(value = "/user/estimate", method = RequestMethod.GET)
	public String ResetPass(Model model, HttpServletRequest request, HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories("1");
		request.setAttribute("categoryList", categoryList);
		
		// filter

				request.setAttribute("hashtag", has);
				List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
				List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
				List<HashTagDTO> listTag = hashtagService.getAllTags("1");
				for (NewCategoryDTO newCate : listNewsCat) {
					int countCat = 0;
					countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
					String count = "(" + countCat + ")";
					newCate.setCount(count);
				}
//				int countCat = newsService.countNewsOfCategory(1);
				request.setAttribute("listNewsCat", listNewsCat);
				request.setAttribute("listTag", listTag);
				request.setAttribute("listNews4Date", listNews4Date);
		return "user/edit/estimateCalo";
	}

	@PostMapping(value = "/user/product/add-product")
	public @ResponseBody int addProductPost(HttpServletRequest request,HttpSession httpSession,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "productDescription", required = false) String productDescription,
			@RequestParam(value = "image", required = false) MultipartFile file,Principal principal) {
		
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserService.findAppUserbyUserName(loginedUser.getUsername());
		Product p = new Product();
		p.setProductName(productName);
		p.setProductDescription(productDescription);
		p.setImage(imgurUtil.uploadImage(file));
		p.setUser(user);
		p.setEnable("0");
		p = productRepository.save(p);

		return p.getId();
	}

	@PostMapping(value = "/user/product/add-resources-to-product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain;charset=UTF-8")
	public String addResourceToProduct(HttpServletRequest request,
			@RequestBody ProductResource2Dto ProductResource2Dto) {
		
		Product p = productRepository.findById(ProductResource2Dto.getProductId()).get();
		for (Resource2Dto r : ProductResource2Dto.getResources()) {
			Resource res = resourceRepository.findById(r.getId()).get();
			ProductResource prodResource = new ProductResource();
			prodResource.setResource(res);
			prodResource.setProduct(p);
			prodResource.setKcal1g(r.getGram());
			productResourceRepository.save(prodResource);
		}
		return "user/edit/manage_product";
	}

	@GetMapping(value = "/user/resource/resourceCat/{id}")
	public @ResponseBody List<ResourceDTO> getResourceFromResouceCategory(@PathVariable("id") int id) {
		return resourceService.getResourceFromWithResouceCatId(id);
	}
	@GetMapping(value = "/user/product/edit-product")
	public String editProduct(HttpServletRequest request, @RequestParam  (name="id") int id,Model model,HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		ProductDTO productDTO= productService.getProductbyId(id);
		model.addAttribute("productDTO", productDTO);
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories("1");
		request.setAttribute("categoryList", categoryList);
		
		// filter

		request.setAttribute("hashtag", has);
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		return "user/edit/edit_product";
	}
	@GetMapping(value = "/user/product/mokhoa")
	public String editmokhoaProduct( @RequestParam  (name="id") int id) {
		ProductDTO productDTO= productService.getProductbyId(id);
		productDTO.setEnable("1");
		productService.updateProduct(productDTO);
		return "redirect:/user/product/search";
	}
	@GetMapping(value = "/user/product/khoa")
	public String editkhoaProduct( @RequestParam  (name="id") int id) {
		ProductDTO productDTO= productService.getProductbyId(id);
		productDTO.setEnable("0");
		productService.updateProduct(productDTO);
		return "redirect:/user/product/search";
	}

	@PostMapping(value = "/user/product/edit-product")
	public @ResponseBody void editProductPost(HttpServletRequest request,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "productDescription", required = false) String productDescription,
			@RequestParam(value = "image", required = false) MultipartFile file,
			@RequestParam(value="id") int id
			) {
		
		ProductDTO p = productService.getProductbyId(id);
		p.setEnable("0");
		p.setProductName(productName);
		p.setProductDescription(productDescription);
		String image=imgurUtil.uploadImage(file);
		if(image!=null) {
			p.setImage(image);
		}
		
		productService.updateProduct(p);
		List<ProductResourceDTO> productResourceDTOs= productResourceService.getProductResourceByProductId(id);
		for(ProductResourceDTO productResourceDTO:productResourceDTOs) {
			productResourceService.deleteProductResource(productResourceDTO.getId());
		}
		
		
	}

	
	@PostMapping(value = "/user/product/edit-resources-to-product")
	@ResponseBody
	public void editResourceToProduct(HttpServletRequest request,
			@RequestBody ProductResource2Dto ProductResource2Dto) {
//		List<ProductResourceDTO> productResourceDTOs= productResourceService.getProductResourceByProductId(productResourceDto.getProductId());
		ProductDTO productDTO= productService.getProductbyId(ProductResource2Dto.getProductId());
		Product product= new Product();
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
	
	@GetMapping(value = "/user/product/delete")
	public String deleteProduct(int id) {
		prService.deleteProductResource(id);
		productRepository.deleteById(id);
		
		return "redirect:/user/product/search";
	}
}
