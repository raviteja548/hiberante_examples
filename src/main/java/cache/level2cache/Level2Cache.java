package cache.level2cache;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.stat.Statistics;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Level2Cache {
    public static void main(String args[]){

        /*
        To enable this class execution, uncomment cache properties & uncomment level2cache.UserDetails mapping
        in hibernate.cfg.xml

         */


        UserDetails usd1 = new UserDetails();
        usd1.setUserId(1);
        usd1.setUserName("one");


        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess1 = sf.openSession();

        Transaction t1 = sess1.beginTransaction();


        UserDetails u1 = (UserDetails)sess1.load(UserDetails.class, 1);
        System.out.println(u1.getUserName());

        u1 = (UserDetails)sess1.load(UserDetails.class, 1);
        System.out.println(u1.getUserName());

        //clear first level cache, so that second level cache is used
        //sess1.evict(u1);
        Map<String, ClassMetadata> classesMetadata = sf.getAllClassMetadata();
        for (String entityName : classesMetadata.keySet()) {
            sf.evictEntity(entityName);
        }


        System.out.println("after clearing cache............");

        UserDetails u2 = (UserDetails)sess1.load(UserDetails.class, 1);
        u2= (UserDetails)sess1.load(UserDetails.class, 1);
        System.out.println(u2.getUserName());

        u2= (UserDetails)sess1.load(UserDetails.class, 2);
        System.out.println(u2.getUserName());


        Session sess2 = sf.openSession();
        u2= (UserDetails)sess2.load(UserDetails.class,1);
        System.out.println(u2.getUserName());


        t1.commit();
        sf.close();






    }
}
