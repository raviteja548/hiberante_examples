package crud;


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
public class CrudClient {
    public static void main(String args[]){

        UserDetails usd1 = new UserDetails();
        usd1.setUserId(1);
        usd1.setUserName("one");
        usd1.setCompany("One Company");

        UserDetails usd2 = new UserDetails();
        usd2.setUserId(2);
        usd2.setUserName("two");
        usd2.setCompany("Two Company");





        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(usd1);
        sess.save(usd2);



        // delete





        UserDetails u2 = (UserDetails) sess.get(UserDetails.class,2);
        System.out.println("Beofre Update"+"\n"+u2.getUserId()+" "+u2.getUserName());
        usd2.setUserName("second user updated");
        UserDetails u22 = (UserDetails) sess.get(UserDetails.class,2);
        System.out.println("After Update"+"\n"+u22.getUserId()+" "+u22.getUserName());

        sess.getTransaction().commit();
        sess.close();

        sess = sf.openSession();
        sess.beginTransaction();



        //usd2.setUserName("second user updated second time");
        //usd2.setCompany("Company Changed");
        sess.update(usd2);
        UserDetails u222 = (UserDetails) sess.get(UserDetails.class,2);
        System.out.println("After Update method execution "+"\n"+u222.getUserId()+" "+u222.getUserName());



        sess.delete(usd1);



        sess.getTransaction().commit();
        sess.close();



    }
}
