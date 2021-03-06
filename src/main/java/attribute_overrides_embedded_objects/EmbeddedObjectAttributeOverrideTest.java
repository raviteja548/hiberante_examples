package attribute_overrides_embedded_objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmbeddedObjectAttributeOverrideTest {
    public static void main(String args[]){

        UserDetails usd = new UserDetails();
        // Need not to set userid , since it will be autogenerated
        usd.setUserName("Embedded Honey  User");
        Address homeAddress = new Address();
        homeAddress.setArea("Attapur");
        homeAddress.setCity("Hyderabad");
        homeAddress.setDoorNo("123-345");
        usd.setHomeAddress(homeAddress);

        Address officeAddress = new Address();
        officeAddress.setArea("Gachibowli");
        officeAddress.setCity("Hyderabad");
        officeAddress.setDoorNo("7-94-948");

        usd.setOfficeAddress(officeAddress);

        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(usd);
        sess.getTransaction().commit();
        sess.close();
       sf.close();


    }
}
