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

/*
usdt_many_1:
USERID	USERNAME
1	ManyToOne User

vehcl_many_1:
VID	VEHICLENAME	US_VID
3692	Active 3G	1
2943	Splendor	1

usdt_many_1_vehcl_many_1:
USER_ID	VEHICLE_ID
1	3692
1	2943
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
