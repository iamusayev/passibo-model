package az.passibo.project.dao.repository;

import az.passibo.project.dao.entity.FavoriteStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteStoreRepository extends JpaRepository<FavoriteStore, Long> {

    @Query("""
            SELECT fs FROM FavoriteStore fs INNER JOIN fs.user u WHERE u.id = :userId
          """)
    List<FavoriteStore> findByUserId(Long userId);

}
