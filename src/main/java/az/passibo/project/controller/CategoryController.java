package az.passibo.project.controller;

import az.passibo.project.annotation.Api;
import az.passibo.project.model.dto.CategoryDto;
import az.passibo.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Api(path = "/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
