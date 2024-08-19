package az.passibo.project.specification;

import az.passibo.project.dao.entity.Store;
import az.passibo.project.model.enums.CategoryName;
import az.passibo.project.util.PredicateUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;


public final class StoreSpecification {

    public static Specification<Store> buildSpecificationForGetAll(CategoryName categoryName) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> storeCategories = root.join("storeCategories");
            Join<Object, Object> category = storeCategories.join("category");
            Predicate[] predicates = PredicateUtil.builder().add(categoryName, name -> criteriaBuilder.equal(category.get("name"), name)).build();
            return criteriaBuilder.and(predicates);
        };
    }
}