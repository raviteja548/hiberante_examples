package hql;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class HQLClient {
    public static void main(String args[]){

        UserDetails usd1 = new UserDetails();
        usd1.setUserId(1);
        usd1.setUserName("one");

        UserDetails usd2 = new UserDetails();
        usd1.setUserId(2);
        usd1.setUserName("two");

        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(usd1);
        sess.save(usd2);
        sess.getTransaction().commit();

        Query query = sess.createQuery("from usdt_hql where userId > 1");
        List<UserDetails> userDetailsList = query.list();
        for(UserDetails userDetails:userDetailsList){
            System.out.println(userDetails.getUserId()+" "+userDetails.getUserName());
        }

        sess.close();



    }
}
