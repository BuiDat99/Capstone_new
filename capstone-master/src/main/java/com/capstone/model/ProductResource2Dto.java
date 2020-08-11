package com.capstone.model;

import java.util.List;

public class ProductResource2Dto {
    private int productId;
    private List<Resource2Dto> resources;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<Resource2Dto> getResources() {
        return this.resources;
    }

    public void setResources(List<Resource2Dto> resources) {
        this.resources = resources;
    }

}
