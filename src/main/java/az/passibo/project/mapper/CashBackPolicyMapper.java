package az.passibo.project.mapper;


import az.passibo.project.dao.entity.CashbackPolicy;
import az.passibo.project.model.dto.CashbackPolicyDto;

public enum CashBackPolicyMapper {

    CASH_BACK_POLICY_MAPPER;

    public CashbackPolicyDto mapEntityToDto(CashbackPolicy entity) {
        Double coffeeShopPercentage = null;
        Double userPercentage = null;
        if (entity.getCoffeeShopPercentage()!= null) {
            coffeeShopPercentage = entity.getCoffeeShopPercentage();
        }
        if (entity.getUserPercentage()!= null) {
            userPercentage = entity.getUserPercentage();
        }
        return CashbackPolicyDto.builder()
                                 .coffeeShopPercentage(coffeeShopPercentage)
                                 .userPercentage(userPercentage)
                                 .build();
    }
}
