package az.passibo.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.List;

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

    private LocalTime openFrom;

    private LocalTime openTo;

    @OneToMany(mappedBy = "store")
    private List<StoreCategory> storeCategories;

    @OneToMany(mappedBy = "store")
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "store")
    private List<StoreDrink> storeDrinks;
}