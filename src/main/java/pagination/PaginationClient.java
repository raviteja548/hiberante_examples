package pagination;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class PaginationClient {
    public static void main(String args[]){

        for(int i=0;i<10;i++){
           UserDetails userDetails = new UserDetails();
        }

        Configuration configuration = new Configuration().configure();
        // service registry in 4.3 version
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        sess.beginTransaction();

        for(int i=0;i<10;i++){
            UserDetails userDetails = new UserDetails();
            userDetails.setUserId(i+1);
            userDetails.setUserName("User "+(i+1));
            sess.save(userDetails);
        }





        sess.getTransaction().commit();

        Query query = sess.createQuery("from usdt_pagi");
        query.setFirstResult(3);
        query.setMaxResults(4);

        List<UserDetails> userDetailsList = query.list();
        for(UserDetails userDetails:userDetailsList){
            System.out.println(userDetails.getUserId()+" "+userDetails.getUserName());
        }


        Query query1 = sess.createQuery("select userName from usdt_pagi");
        List<String> userNamesList = query1.list();
        for(String userName:userNamesList){
                System.out.println(userName);
        }






        sess.close();



    }
}
