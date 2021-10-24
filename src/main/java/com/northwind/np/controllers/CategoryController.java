package com.northwind.np.controllers;

import com.northwind.np.dto.CategoryDescriptionDTO;
import com.northwind.np.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryService getCategoryService() {
        return categoryService;
    }

    @GetMapping("/northwind/categories")
    public List<CategoryDescriptionDTO> getCategoryDescriptions(@RequestParam(name = "keyword", required = false) List<String> keywords) {
        if(keywords != null) {
            return categoryService.getCategoryDescriptionsByKeyword(keywords);
        }
        return categoryService.getCategoryDescriptions();
    }

    @GetMapping("/northwind/categories/{id}")
    public List<CategoryDescriptionDTO> getCategoryDescriptionsById(@PathVariable Integer id) {
        return categoryService.getCategoryDescriptionsById(id);
    }

}
