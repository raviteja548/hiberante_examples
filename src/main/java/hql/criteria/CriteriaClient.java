package hql.criteria;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class CriteriaClient {
    public static void main(String args[]){


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

        //By Default Criteria evaluates and conditions for every restriction
        Criteria  criteria = sess.createCriteria(UserDetails.class);
        criteria.add(Restrictions.gt("userId",1)).add(Restrictions.le("userId",5));
        List<UserDetails> userDetailsList1 = criteria.list();
        for(UserDetails userDetails:userDetailsList1){
            System.out.println(userDetails.getUserId()+" "+userDetails.getUserName());
        }



        // To add or conditions
        System.out.println("---Criteria Or Conditions");
        Criteria criteria1 = sess.createCriteria(UserDetails.class);
        criteria1.add(Restrictions.or(Restrictions.eq("userId",5),Restrictions.eq("userId",10)));
        List<UserDetails> users = criteria1.list();
        for(UserDetails user : users){
            System.out.println(user.getUserId()+" "+user.getUserName());
        }


        sess.close();



    }
}
