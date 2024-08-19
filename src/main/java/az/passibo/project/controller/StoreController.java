package az.passibo.project.controller;

import az.passibo.project.annotation.Api;
import az.passibo.project.model.dto.StoreDto;
import az.passibo.project.model.enums.CategoryName;
import az.passibo.project.model.response.NearestStoreResponse;
import az.passibo.project.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Api(path = "/v1/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public List<StoreDto> getAll(Long userId,
                                 Double latitude,
                                 Double longitude,
                                 CategoryName categoryName) {
        return storeService.getAll(userId, latitude, longitude, categoryName);
    }

    @GetMapping("/nearest")
    public List<NearestStoreResponse> getNearestStores(Long userId,
                                                       Double latitude,
                                                       Double longitude) {
        return storeService.getNearestStores(userId, latitude, longitude);
    }

    @GetMapping("/recommended")
    public List<StoreDto> getRecommendedStores(Long userId,
                                               Double latitude,
                                               Double longitude) {
        return storeService.getRecommendedStores(userId, latitude, longitude);
    }
}
