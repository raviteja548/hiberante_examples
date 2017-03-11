package mapping.many_one;

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
public class ManyToOneTest {
    public static void main(String args[]){


        UserDetails usd = new UserDetails();
        usd.setUserId(1);
        usd.setUserName("ManyToOne User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Active 3G");
        vehicle.setVid(3692);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Splendor");
        vehicle1.setVid(2943);

        vehicle.setUserDetails(usd);
        vehicle1.setUserDetails(usd);

        usd.getVehicleCollection().add(vehicle);
        usd.getVehicleCollection().add(vehicle1);



        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();

        sess.save(usd);
        sess.save(vehicle);
        sess.save(vehicle1);

        sess.getTransaction().commit();
        sess.close();
    }
}
