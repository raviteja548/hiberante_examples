package otherannotations;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String args[]){

        UserDetails usd1 = new UserDetails();
        usd1.setUserId(1);
        usd1.setUserName("one");
        usd1.setAddress("Hyd");
        usd1.setJoinedDate(new Date());
        usd1.setDescription("This is a huge text");


        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(usd1);
        sess.getTransaction().commit();


        sess.close();



    }
}
