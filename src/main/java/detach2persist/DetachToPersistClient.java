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

       // transient state
        UserDetails usd1 = new UserDetails();
        usd1.setUserId(1);
        usd1.setUserName("one");

        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        // It is in persistent state, insert query will run for the below line
        sess.save(usd1);
        sess.getTransaction().commit();
        sess.close();
        // Now the object is in detched state




        //In order to bring the object from detached to persisten state once again use update method opening the session once again
        System.out.println("-------------BRINGING DETACHED TO PERSISTENT");
        sess = sf.openSession();
        sess.beginTransaction();

        //comment below line, only select query will be fired as theres no change in data.
        //uncomment below line, both select and update querys will run
       // usd1.setUserName("Update User2");


        //Bringing of object from detached state to persistent state is only possible by update method. Save cant be used
        //because it will add the row once again which will be a unique constarint violation


        //The below line we are just updating object 'not at all change in object values', using @org.hibernate.annotations.Entity(selectBeforeUpdate = true) annotation
        // we ask hibernate to run an update query only if the value in object changes. so it runs a select query to verify changes in db
       // update query will be fired even u make changes or may not make changes to the userDetails object.

        sess.update(usd1);

        sess.getTransaction().commit();
        sess.close();





    }
}
