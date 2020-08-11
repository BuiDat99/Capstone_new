package com.capstone.model;

public class MenuProductDTO {

	private int id;
	private ProductDTO product;
	private MenuDTO menu;
	
	public MenuProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public MenuProductDTO(int id, ProductDTO product, MenuDTO menu) {
		super();
		this.id = id;
		this.product = product;
		this.menu = menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public MenuDTO getMenu() {
		return menu;
	}

	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}
	
	
	
}
