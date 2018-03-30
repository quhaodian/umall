package com.quhaodian.umall.data.app;

import com.quhaodian.umall.data.entity.PhoneProduct;
import com.quhaodian.umall.data.entity.Product;
import com.quhaodian.umall.data.entity.RoomProduct;
import com.quhaodian.umall.data.service.PhoneProductService;
import com.quhaodian.umall.data.service.ProductService;
import com.quhaodian.umall.data.service.RoomProductService;

import java.util.List;

public class ProductApp {

    public static void main(String[] args) {


        PhoneProductService phoneProductService = ObjectFactory.get().getBean(PhoneProductService.class);

        PhoneProduct bean = new PhoneProduct();
        bean.setHeight(1);
        bean.setWeight(100);
        bean.setName("ada");
        //phoneProductService.save(bean);

        RoomProductService roomProductService = ObjectFactory.get().getBean(RoomProductService.class);

        RoomProduct roomProduct = new RoomProduct();
        roomProduct.setArea(100);
        roomProduct.setName("产品");
        //roomProductService.save(roomProduct);

        ProductService productService = ObjectFactory.get().getBean(ProductService.class);
        //productService.save(bean);
        //productService.save(roomProduct);

        List<Product> ps = productService.list(0, 10, null, null);
        for (Product p : ps) {
            System.out.println(p.getClass().getSimpleName());
        }
        List<RoomProduct> roomProducts= roomProductService.list(0,10,null,null);
        System.out.println("***************************************");
        for (RoomProduct product : roomProducts) {
            System.out.println(product.getClass().getSimpleName());
        }

    }
}
