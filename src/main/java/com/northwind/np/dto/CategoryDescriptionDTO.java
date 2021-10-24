package com.northwind.np.dto;

import com.northwind.np.entities.CategoryEntity;

public class CategoryDescriptionDTO {

    private String name;
    private String description;

    public CategoryDescriptionDTO(CategoryEntity categoryEntity) {
        this.name = categoryEntity.getCategoryName();
        this.description = categoryEntity.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
