package inheritance.tableperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 21/8/15
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class InheritanceTablePerClassClient {
    public static void main(String args[]){

        Vehicle vehicle = new Vehicle();
        vehicle.setVid(1);
        vehicle.setVname("Vehicle");


        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVid(2);
        twoWheeler.setVname("Activa");
        twoWheeler.setSteeringHandle("Bike Handle");

        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVid(3);
        fourWheeler.setVname("Porsche");
        fourWheeler.setSteeringWheel("Car Steering");








        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(vehicle);
        sess.save(twoWheeler);
        sess.save(fourWheeler);
        sess.getTransaction().commit();
        sess.close();



    }
}

