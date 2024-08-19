package az.passibo.project.service;

import az.passibo.project.dao.entity.FavoriteStore;
import az.passibo.project.dao.repository.StoreRepository;
import az.passibo.project.model.dto.StoreDto;
import az.passibo.project.model.enums.CategoryName;
import az.passibo.project.model.response.NearestStoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.passibo.project.mapper.StoreMapper.STORE_MAPPER;
import static az.passibo.project.specification.StoreSpecification.buildSpecificationForGetAll;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final FavoriteStoreService favoriteStoreService;


    public List<StoreDto> getRecommendedStores(Long userId,
                                               Double latitude,
                                               Double longitude) {
        var favoriteCoffeeShopIds = findFavoriteCoffeeShopIds(userId);
        var allOrderedByRecommendedOrderAndId = storeRepository.findAllOrderedByRecommendedOrderAndId();
        return  STORE_MAPPER.mapStorePageToResponses(allOrderedByRecommendedOrderAndId, favoriteCoffeeShopIds, latitude, longitude);
    }

    public List<NearestStoreResponse> getNearestStores(Long userId,
                                                       Double latitude,
                                                       Double longitude) {
        return storeRepository.findNearestStores(latitude, longitude, userId);
    }

    public List<StoreDto> getAll(Long userId, Double latitude, Double longitude, CategoryName categoryName) {
        var storeSpecification = buildSpecificationForGetAll(categoryName);
        var favoriteCoffeeShopIds = findFavoriteCoffeeShopIds(userId);
        return STORE_MAPPER.mapStorePageToResponses(storeRepository.findAll(storeSpecification), favoriteCoffeeShopIds, latitude, longitude);
    }


    private List<Long> findFavoriteCoffeeShopIds(Long userId) {
        return favoriteStoreService.getFavoriteStoresByUserId(userId).stream()
                                                                     .map(FavoriteStore::getId)
                                                                     .toList();
    }
}