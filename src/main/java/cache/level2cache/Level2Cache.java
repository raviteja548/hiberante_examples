package cache.level2cache;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Level2Cache {
    public static void main(String args[]){

        /*
        To enable this class execution, uncomment cache properties & uncomment level2cache.UserDetails mapping
        in hibernate.cfg.xml

         */


        UserDetails usd1 = new UserDetails();
        usd1.setUserId(1);
        usd1.setUserName("one");


        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(usd1);
        sess.getTransaction().commit();
        System.out.println("-----------Cache Example-------------");
        UserDetails u1 = (UserDetails) sess.get(UserDetails.class,1);
        UserDetails u2 = (UserDetails) sess.get(UserDetails.class,1);

        System.out.println("Second query will not be fired for u1 & u2 bcoz the object usd1 is already in db");

        sess.close();

        System.out.println("After reopen session");
        Session sess1 = sf.openSession();
        sess1.beginTransaction();
        UserDetails u3 = (UserDetails) sess1.get(UserDetails.class,1);
        UserDetails u4 = (UserDetails) sess1.get(UserDetails.class,1);


    }
}
