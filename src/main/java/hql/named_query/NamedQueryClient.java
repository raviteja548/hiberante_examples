package hql.named_query;


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
public class NamedQueryClient {
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


        Query query = sess.getNamedQuery("queryUsers.byIds");
        query.setInteger(0,5);


        List<UserDetails> userDetailsList1 = query.list();
        for(UserDetails userDetails:userDetailsList1){
            System.out.println(userDetails.getUserId()+" "+userDetails.getUserName());
        }

        sess.close();



    }
}
