package az.passibo.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

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
}