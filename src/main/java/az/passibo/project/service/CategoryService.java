package az.passibo.project.service;

import az.passibo.project.dao.repository.CategoryRepository;
import az.passibo.project.mapper.CategoryMapper;
import az.passibo.project.model.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDto> getAllCategories() {
        return CategoryMapper.CATEGORY_MAPPER.entitiesToDtos(categoryRepository.findAll());
    }
}
