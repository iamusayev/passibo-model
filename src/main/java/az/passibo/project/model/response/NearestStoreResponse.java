package az.passibo.project.model.response;


import java.time.LocalTime;

public interface NearestStoreResponse {
     Long getId();
     String getName();
     String getAddress();
     Boolean getHasCashback();
     Boolean getHasOffer();
     Double getDistance();
     Boolean getIsFavourite();
     String getMainPhoto();
     Boolean getHasDrinkOfTheDay();
     LocalTime getWorkingHoursFrom();
     LocalTime getWorkingHoursTo();
     Double getCashbackPolicyCoffeeShopPercentage();
     Double getCashbackPolicyUserPercentage();
}