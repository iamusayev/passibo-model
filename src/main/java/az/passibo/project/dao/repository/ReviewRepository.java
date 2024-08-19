package az.passibo.project.dao.repository;

import az.passibo.project.dao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
