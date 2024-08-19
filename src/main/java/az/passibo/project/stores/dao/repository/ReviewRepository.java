package az.passibo.project.stores.dao.repository;

import az.passibo.project.stores.dao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
