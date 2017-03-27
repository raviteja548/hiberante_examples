package mapping.one_many;

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
usdt_1_many:
USERID	USERNAME
1	OneToMany User

vehcl_1_many:
VID	VEHICLENAME
3692	Active 3G
2943	Splendor

usdt_1_many_vehcl_1_many:
USER_ID	VEHICLE_ID
1	3692
1	2943

 */
public class OneToManyTest {
    public static void main(String args[]){
        //Refere UserDetails class for comments

        UserDetails usd = new UserDetails();
        usd.setUserId(1);
        usd.setUserName("OneToMany User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Active 3G");
        vehicle.setVid(3692);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Splendor");
        vehicle1.setVid(2943);

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
