package az.passibo.project.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "cashback_policies")
public class CashbackPolicy {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Double coffeeShopPercentage;
    private Double userPercentage;
    @OneToOne(mappedBy = "cashbackPolicy")
    @JoinColumn(name = "store_id")
    private Store store;
}