package detach2persist;


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
public class DetachToPersistClient {
    public static void main(String args[]){

        UserDetails usd1 = new UserDetails();
        usd1.setUserId(1);
        usd1.setUserName("one");

        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        // It is in persistent state
        sess.save(usd1);
        sess.getTransaction().commit();
        sess.close();
        // Now the object is in detched state

        //In order to bring the object from detached to persisten state once again use update method opening the session once again
        sess = sf.openSession();
        sess.beginTransaction();


        //usd1.setUserName("Update User2");
        //Bringing of object from detached state to persistent state is only possible by update method. Save cant be used
        //because it will add the row once again which will be a unique constarint violation


       // update query will be fired even u make changes or may not make changes to the userDetails object.
        //In order to run this update function only if there is a change in object use annotation
        // @org.hibernate.annotations.Entity(selectBeforeUpdate = true) so that it will make a query against
        sess.update(usd1);

        sess.getTransaction().commit();
        sess.close();





    }
}
