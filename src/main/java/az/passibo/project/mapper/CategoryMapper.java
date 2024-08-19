package az.passibo.project.mapper;

import az.passibo.project.dao.entity.Category;
import az.passibo.project.model.dto.CategoryDto;

import java.util.List;

public enum CategoryMapper {

    CATEGORY_MAPPER;


    public CategoryDto entityToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public List<CategoryDto> entitiesToDtos(List<Category> categories) {
        return categories.stream()
                .map(this::entityToDto)
                .toList();
    }
}
