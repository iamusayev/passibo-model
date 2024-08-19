package az.passibo.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private Boolean isFavourite;
    private String mainPhoto;
    private Double rating;
    private Double distance;
    private Boolean hasCashback;
    private Boolean hasOffer;
    private Double latitude;
    private Double longitude;
    private LocalTime workingHoursFrom;
    private LocalTime workingHoursTo;
    private CashbackPolicyDto cashbackPolicy;
}