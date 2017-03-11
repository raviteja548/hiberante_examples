package hql.parameter_binding;


import hql.parameter_binding.UserDetails;
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
public class ParamBindClient {
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

        String userId = "5 or 1 = 1";
        Query query = sess.createQuery("from usdt_param_bind where userId > "+userId);
        //This creates potential problems, this is called sql injection. It would not fetch records above 5, instead it would fetch all the records
        List<UserDetails> userDetailsList = query.list();
        for(UserDetails userDetails:userDetailsList){
            System.out.println(userDetails.getUserId()+" "+userDetails.getUserName());
        }

        System.out.println("------------Parameter Binding----------------");
        int usid = 7;
        //cannot define positional parameter after any named parameters
        Query q1 = sess.createQuery("from usdt_param_bind where userId > ? and userName = :userName");
        q1.setInteger(0,usid);
        q1.setString("userName","User 9");

        List<UserDetails> userDetailsList1 = q1.list();
        for(UserDetails userDetails:userDetailsList1){
            System.out.println(userDetails.getUserId()+" "+userDetails.getUserName());
        }

        sess.close();



    }
}
