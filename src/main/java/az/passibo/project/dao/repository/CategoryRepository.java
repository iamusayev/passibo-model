package az.passibo.project.dao.repository;

import az.passibo.project.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}