package com.northwind.np.services;

import com.northwind.np.dto.CategoryDescriptionDTO;
import com.northwind.np.entities.CategoryEntity;
import com.northwind.np.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDescriptionDTO> getCategoryDescriptions() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToCategoryDescriptionDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDescriptionDTO> getCategoryDescriptionsById(Integer id) {
        return categoryRepository.findById(id)
                .stream()
                .map(this::convertToCategoryDescriptionDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDescriptionDTO> getCategoryDescriptionsByKeyword(List<String> keywords) {
        List<CategoryEntity> entities = new ArrayList<>();
        for (String keyword : keywords) {
            for (CategoryEntity entity : categoryRepository.findAll()) {
                String k = keyword.toLowerCase();
                if (entity.getCategoryName().toLowerCase().contains(k) || entity.getDescription().toLowerCase().contains(k)) {
                    if(!entities.contains(entity)) {
                        entities.add(entity);
                    }
                }
            }
        }
        return entities.stream().map(this::convertToCategoryDescriptionDTO).collect(Collectors.toList());
    }

    private CategoryDescriptionDTO convertToCategoryDescriptionDTO(CategoryEntity categoryEntity) {
        return new CategoryDescriptionDTO(categoryEntity);
    }


}
