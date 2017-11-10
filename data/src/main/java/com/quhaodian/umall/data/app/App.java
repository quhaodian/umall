package com.quhaodian.umall.data.app;

import com.quhaodian.activiti.data.entity.Act;
import com.quhaodian.imake.ChainMake;
import com.quhaodian.imake.template.hibernate.TemplateHibernateDir;
import com.quhaodian.imake.templates.adminlte.TemplateAdminLTE;
import com.quhaodian.user.data.entity.UserAccount;
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
        make.setDao(false);
        make.setService(false);
        make.setAction(false);
        make.setView(true);
        make.setMenus("1,12,14");
        // UserOauthToken.
        make.makes(Act.class);
    }
}
