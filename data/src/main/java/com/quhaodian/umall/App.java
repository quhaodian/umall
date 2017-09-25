package com.quhaodian.umall;

import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.adminlte.TemplateAdminLTE;
import com.ada.user.data.entity.UserAccount;
import com.quhaodian.umall.data.entity.Member;

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
        make.setAction(true);
        make.setView(true);
        make.setMenus("1,22,39");
        // UserOauthToken.
        make.makes(Member.class);
    }
}
