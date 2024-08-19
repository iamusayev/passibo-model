package az.passibo.project.stores.dao.repository;

import az.passibo.project.stores.dao.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
