package com.northwind.np.controllers;

import com.northwind.np.dto.ProductListingDTO;
import com.northwind.np.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/northwind/products")
    public List<ProductListingDTO> getAllProductListings() {
        return productService.getAllProductListings();
    }

    @GetMapping("/northwind/products/available")
    public List<ProductListingDTO> getAvailableProductListings() {
        return productService.getAvailableProductListings();
    }

    @GetMapping("/northwind/products/unavailable")
    public List<ProductListingDTO> getUnavailableProductListings() {
        return productService.getUnavailableProductListings();
    }

}
