package cascade;

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
public class CascadeTest {
    public static void main(String args[]){

        // Refer UserDetails for comments
        UserDetails usd = new UserDetails();
        usd.setUserId(1);
        usd.setUserName("Cascade User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Active 3G");
        vehicle.setVid(3692);

        usd.setVehicle(vehicle);


        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();

        sess.persist(usd);
        //sess.save(vehicle);  // not necessary to save vehicle object, as we are using cascade


        sess.getTransaction().commit();
        sess.close();
    }
}
