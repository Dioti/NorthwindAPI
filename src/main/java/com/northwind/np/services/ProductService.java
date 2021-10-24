package com.northwind.np.services;

import com.northwind.np.dto.ProductListingDTO;
import com.northwind.np.entities.ProductEntity;
import com.northwind.np.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductListingDTO> getAllProductListings() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToProductListingDTO)
                .collect(Collectors.toList());
    }

    public List<ProductListingDTO> getAvailableProductListings() {
        Predicate<ProductEntity> inStock = p -> p.getUnitsInStock() > 0;
        Predicate<ProductEntity> notDiscontinued = p -> !p.getDiscontinued();
        return productRepository.findAll()
                .stream()
                .filter(inStock.and(notDiscontinued))
                .map(this::convertToProductListingDTO)
                .collect(Collectors.toList());
    }

    public List<ProductListingDTO> getUnavailableProductListings() {
        Predicate<ProductEntity> outOfStock = p -> p.getUnitsInStock() <= 0;
        Predicate<ProductEntity> discontinued = p -> p.getDiscontinued();
        return productRepository.findAll()
                .stream()
                .filter(outOfStock.or(discontinued))
                .map(this::convertToProductListingDTO)
                .collect(Collectors.toList());
    }

    public List<ProductListingDTO> getOutOfStockProductListings() {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getUnitsInStock() <= 0)
                .map(this::convertToProductListingDTO)
                .collect(Collectors.toList());
    }

    public List<ProductListingDTO> getDiscontinuedProductListings() {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getDiscontinued())
                .map(this::convertToProductListingDTO)
                .collect(Collectors.toList());
    }

    private ProductListingDTO convertToProductListingDTO(ProductEntity productEntity) {
        return new ProductListingDTO(productEntity);
    }

}
