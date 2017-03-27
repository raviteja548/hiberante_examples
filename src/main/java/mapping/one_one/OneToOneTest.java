package mapping.one_one;

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

/*
USERID	USERNAME	US_VID
1	OneToOne User	8088

VID	  VEHICLENAME
8088  Fazer
 */
public class OneToOneTest {
    public static void main(String args[]){
         //Refer UserDetails class for comments

        UserDetails usd = new UserDetails();
        usd.setUserId(1);
        usd.setUserName("OneToOne User");
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
        sess.save(usd);
        sess.save(vehicle);
        sess.getTransaction().commit();
        sess.close();
    }
}
