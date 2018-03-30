package com.quhaodian.umall.data.app;

import com.quhaodian.imake.ChainMake;
import com.quhaodian.imake.template.hibernate.TemplateHibernateDir;
import com.quhaodian.imake.templates.adminlte.TemplateAdminLTE;
import com.quhaodian.umall.data.entity.PhoneProduct;
import com.quhaodian.umall.data.entity.Product;
import com.quhaodian.umall.data.entity.RoomProduct;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File file = new File("E:\\mvnspace\\umall\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setAction("com.quhaodian.umall.controller.admin");
        make.setView(file);
        make.setDao(true);
        make.setService(true);
        make.setAction(false);
        make.setView(false);
        make.setMenus("1,12,14");
        // UserOauthToken.
        make.makes(Product.class);
        make.makes(RoomProduct.class);
        make.makes(PhoneProduct.class);

    }
}
