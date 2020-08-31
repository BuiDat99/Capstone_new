package com.capstone.model;

import java.util.List;

public class ProductDTO {

	private int id;
	private String productName;
	private String image;
	private List<String> resources;
	private List<ResourceDTO> resource;
	private List<ProductResourceDTO> productResourceDTOs;
	private String productDescription;
	private String enable;
	private AppUserDTO appUserDTO;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(int id, String productName, String image, List<String> resources, List<ResourceDTO> resource,
			List<ProductResourceDTO> productResourceDTOs, String productDescription, String enable,
			AppUserDTO appUserDTO) {
		super();
		this.id = id;
		this.productName = productName;
		this.image = image;
		this.resources = resources;
		this.resource = resource;
		this.productResourceDTOs = productResourceDTOs;
		this.productDescription = productDescription;
		this.enable = enable;
		this.appUserDTO = appUserDTO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<String> getResources() {
		return resources;
	}
	public void setResources(List<String> resources) {
		this.resources = resources;
	}
	public List<ResourceDTO> getResource() {
		return resource;
	}
	public void setResource(List<ResourceDTO> resource) {
		this.resource = resource;
	}
	public List<ProductResourceDTO> getProductResourceDTOs() {
		return productResourceDTOs;
	}
	public void setProductResourceDTOs(List<ProductResourceDTO> productResourceDTOs) {
		this.productResourceDTOs = productResourceDTOs;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public AppUserDTO getAppUserDTO() {
		return appUserDTO;
	}
	public void setAppUserDTO(AppUserDTO appUserDTO) {
		this.appUserDTO = appUserDTO;
	}
	

}
