package org.ravi.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateTest {
    public static void main(String args[]){


        UserDetails usd = new UserDetails();
        usd.setUserId(2);
        usd.setUserName("Second User");
        usd.setPassword("secret");
        usd.setJoinedDate(new Date());

        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(usd);
        sess.getTransaction().commit();
        sess.close();

        usd = null;
        sess = sf.openSession();
        sess.beginTransaction();

        UserDetails out = (UserDetails) sess.get(UserDetails.class,2);
        System.out.println(out.getUserName()+" "+out.getUserId());


    }
}
