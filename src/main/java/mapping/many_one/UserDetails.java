package mapping.many_one;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
/*
Scenario: Many to One
          UserDetails has a reference to collection item hence relation will be 1-M
          Use annotation @OneToMany. @JoinTable annotation is optional.
          Data is stored in individual tables and a new table is created to store relationships between these 2 tables.
          attributes for jointable 1. joinColumns is primary key from UserDetails table
                                   2. InverseJoinColumns is primary key of Vehicle table
          Here we have reference only in UserTable, we cant really fetch details of user from vehicle table,
                For that create a reference of user in vehicle and mark with @ManyToOne annotation
          Then we can fetch vehicles from user & user from vehicle as well
 */
    @Entity(name="usdt_many_1")
    @Table(name="usdt_many_1")
public class UserDetails {

    @Id
    private int userId;
    private String userName;
    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Collection<Vehicle> vehicleCollection = new ArrayList<Vehicle>();

    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //@Column(name="uname")
    public String getUserName() {
        return userName+""+userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
