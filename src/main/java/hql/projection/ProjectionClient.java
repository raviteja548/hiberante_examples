package hql.projection;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
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
public class ProjectionClient {
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

      Integer maxUserId = (Integer)sess.createCriteria(UserDetails.class).setProjection(Projections.max("userId")).uniqueResult();
                    System.out.println("Max UserId"+maxUserId);



        //Example class in Hibernate
        UserDetails usd5 = new UserDetails();
        usd5.setUserId(5);
        usd5.setUserName("User 5");

        Example example = Example.create(usd5);



        Criteria c = sess.createCriteria(UserDetails.class).add(example);
        List<UserDetails> outPut = (List<UserDetails>)c.list();
        for (UserDetails u: outPut){
            System.out.println(u.getUserId() +" "+ u.getUserName());
        }

        sess.close();



    }
}
