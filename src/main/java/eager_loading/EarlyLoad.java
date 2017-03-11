package eager_loading;

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
public class EarlyLoad {
    public static void main(String args[]){

        UserDetails usd = new UserDetails();
        // Need not to set userid , since it will be autogenerated
        usd.setUserId(11);
        usd.setUserName("EarlyLoad  User");
        Address add1 = new Address();
        add1.setArea("Attapur");
        add1.setCity("Hyderabad");
        add1.setDoorNo("123-345");
        Address add2 = new Address();
        add2.setArea("Gachibowli");
        add2.setCity("Hyderabad");
        add2.setDoorNo("7-94-948");

        /*Set<Address> addressSet = new HashSet<Address>();
        addressSet.add(add1);
        addressSet.add(add2);*/

        usd.getListAddress().add(add1);
        usd.getListAddress().add(add2);

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
        usd = (UserDetails)sess.get(UserDetails.class,11);
        // close the session, since this is lazy loaded list of address can be fetched only when u call getter, so size cant be printed
        sess.close();
        System.out.println(usd.getListAddress().size());


    }
}
