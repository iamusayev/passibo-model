package az.passibo.project.mapper;

import az.passibo.project.dao.entity.Store;
import az.passibo.project.model.dto.CashbackPolicyDto;
import az.passibo.project.model.dto.StoreDto;

import java.util.List;

import static az.passibo.project.mapper.CashBackPolicyMapper.CASH_BACK_POLICY_MAPPER;
import static az.passibo.project.util.DistanceCalculator.DISTANCE_CALCULATOR;

public enum StoreMapper {
    STORE_MAPPER;

    public List<StoreDto> mapStorePageToResponses(List<Store> stores, List<Long> favoritestoreIds, Double latitude, Double longitude) {
        return stores.stream()
                .map(store -> {
                    boolean isFavorite = favoritestoreIds.contains(store.getId());
                    var distance = (latitude != null && longitude != null) ? DISTANCE_CALCULATOR.calculateDistance(latitude, longitude, store.getLatitude(), store.getLongitude()) : null;
                    return STORE_MAPPER.mapEntityToDtoForRecommends(store, isFavorite, distance);
                }).toList();
    }

    public StoreDto mapEntityToDtoForRecommends(Store store, Boolean isFavorite, Double distance) {
        CashbackPolicyDto cashBackPolicyDto = null;
        if (store.getCashbackPolicy() != null){
            cashBackPolicyDto = CASH_BACK_POLICY_MAPPER.mapEntityToDto(store.getCashbackPolicy());
        }
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .description(store.getDescription())
                .isFavourite(isFavorite)
                .distance(distance)
                .longitude(store.getLongitude())
                .latitude(store.getLatitude())
                .workingHoursFrom(store.getWorkingHoursFrom())
                .workingHoursTo(store.getWorkingHoursTo())
                .cashbackPolicy(cashBackPolicyDto)
                .hasCashback(store.getCashbackPolicy() != null)
                .hasOffer(!store.getStoreOffers().isEmpty())
                .build();
    }
}