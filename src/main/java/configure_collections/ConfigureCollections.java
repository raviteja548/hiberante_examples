package configure_collections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigureCollections {
    public static void main(String args[]){

        UserDetails usd = new UserDetails();
        // Need not to set userid , since it will be autogenerated
        usd.setUserName("EarlyLoad  User");
        Address add1 = new Address();
        add1.setArea("Attapur");
        add1.setCity("Hyderabad");
        add1.setDoorNo("123-345");
        Address add2 = new Address();
        add2.setArea("Gachibowli");
        add2.setCity("Hyderabad");
        add2.setDoorNo("7-94-948");
        usd.getListAddress().add(add1);
        usd.getListAddress().add(add2);

        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(usd);
        sess.getTransaction().commit();
        sess.close();



    }
}
