package mapping.many_many;

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
usdt_mny_mny:
USERID	USERNAME
1	ManyToMany User
2	ManyToMany User

vehcl_mny_mny:
VID	VEHICLENAME
3692	Active 3G
2943	Splendor

usdt_mny_mny_vehcl_mny_mny:
USERDETAILSLIST_USERID	VEHICLECOLLECTION_VID
1	3692
1	2943
2	2943
 */
public class ManyToManyTest {
    public static void main(String args[]){
         //refere UserDetails for further comments
        // u can either use mapped by attribute in either of the POJO's, including at one POJO helps to create only 1
        //table, else hibernate would create 2 tables for mapping as user_vehicle and vehicle_user


        UserDetails usd = new UserDetails();
        usd.setUserId(1);
        usd.setUserName("ManyToMany User");
        UserDetails usd1 = new UserDetails();
        usd1.setUserId(2);
        usd1.setUserName("ManyToMany User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Active 3G");
        vehicle.setVid(3692);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Splendor");
        vehicle1.setVid(2943);



        usd.getVehicleCollection().add(vehicle);
        usd.getVehicleCollection().add(vehicle1);
        usd1.getVehicleCollection().add(vehicle1);
        vehicle.getUserDetailsList().add(usd);
        vehicle.getUserDetailsList().add(usd1);
        vehicle1.getUserDetailsList().add(usd1);


        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();

        sess.save(usd);
        sess.save(usd1);
        sess.save(vehicle);
        sess.save(vehicle1);

        sess.getTransaction().commit();
        sess.close();
    }
}
