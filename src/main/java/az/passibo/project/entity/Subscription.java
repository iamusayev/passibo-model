package az.passibo.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer quantity;

    private Integer durationInDays;

    private Integer dailyLimit;

    private Double price;

    @ManyToOne(fetch = LAZY)
    private Store store;

    @ManyToOne(fetch = LAZY)
    private Drink drink;

    private LocalDateTime createdAt;
}