package com.quhaodian.umall.data.entity;

import com.quhaodian.data.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "bs_product_phone")
public class PhoneProduct extends Product {

    private Integer weight;

    private Integer height;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
