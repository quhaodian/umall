package com.quhaodian.umall.data.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bs_product_room")
public class RoomProduct extends Product {

    /**
     * 面积
     */
    private Integer area;

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
