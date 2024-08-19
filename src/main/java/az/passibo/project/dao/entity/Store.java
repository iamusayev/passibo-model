package az.passibo.project.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private Double longitude;

    private Double latitude;

    private String address;

    private LocalTime workingHoursFrom;

    private LocalTime workingHoursTo;

    private Integer recommendedOrder;

    private String description;

    @OneToOne(cascade = ALL)
    private CashbackPolicy cashbackPolicy;

    @OneToMany(mappedBy = "store")
    private List<StorePhoto> photos;

    @OneToMany(mappedBy = "store")
    private List<StoreContact> storeContacts;

    @OneToMany(mappedBy = "store")
    private List<StoreCategory> storeCategories;

    @OneToMany(mappedBy = "store")
    private List<StoreOffer> storeOffers;

    @OneToMany(mappedBy = "store")
    private List<StoreDrink> storeDrinks;

    @OneToMany(mappedBy = "store")
    private List<FavoriteStore> favoriteStores;
}