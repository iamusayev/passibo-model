package az.passibo.project.dao.repository;

import az.passibo.project.dao.entity.Store;
import az.passibo.project.model.response.NearestStoreResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long>, JpaSpecificationExecutor<Store> {

    @Query("SELECT store FROM Store store ORDER BY store.recommendedOrder ASC, store.id ASC")
    List<Store> findAllOrderedByRecommendedOrderAndId();


    @Query(value = """
            SELECT stores.id AS id,
                   stores.name AS name,
                   stores.address AS address,
                   (SELECT photo_url FROM store_photos WHERE store_id = stores.id AND is_main = true LIMIT 1) AS mainPhoto,
                   CASE WHEN fs.id IS NOT NULL THEN true ELSE false END AS isFavourite,
                   calculate_haversine_distance(:lat1, :lon1, stores.latitude, stores.longitude) AS distance,
                   cp.shops_percentage AS cashbackPolicyCoffeeShopPercentage,
                   cp.user_percentage AS cashbackPolicyUserPercentage,
                   stores.working_hours_from AS workingHoursFrom,
                   stores.working_hours_to AS workingHoursTo,
                   CASE WHEN EXISTS (SELECT 1 FROM store_offers so WHERE so.store_id = stores.id AND so.is_active = true) THEN true ELSE false END AS hasOffer
            FROM stores stores
            LEFT JOIN favorite_stores fs ON stores.id = fs.store_id AND fs.user_id = :userId
            LEFT JOIN cashback_policies cp ON stores.cashback_policy_id = cp.id
            """, nativeQuery = true)
    List<NearestStoreResponse> findNearestStores(Double lat1, Double lon1, Long userId);

}