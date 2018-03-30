package com.quhaodian.umall.data.entity;

import com.quhaodian.data.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "bs_product")
@Inheritance(strategy= InheritanceType.JOINED)
public class Product extends AbstractEntity {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
