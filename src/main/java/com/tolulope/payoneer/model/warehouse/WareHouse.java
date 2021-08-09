package com.tolulope.payoneer.model.warehouse;

import com.tolulope.payoneer.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WareHouse extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int unit_price;
    private int unit;
    private String category;

    public WareHouse(String name, String description, int unit_price, int unit, String category) {
        this.name = name;
        this.description = description;
        this.unit_price = unit_price;
        this.unit = unit;
        this.category = category;
    }
}
