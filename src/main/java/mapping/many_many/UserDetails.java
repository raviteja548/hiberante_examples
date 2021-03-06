package mapping.many_many;

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
Scenario: Many To Many
          One User can have many vehicles & 1 vehicle may be owned by different users.
          Use @ManyToMany annotation on both reference in UserDetails & Vehicle class.
          Data will be inserted in both tables and further 2 tables will be created by default mapping by user-vehicle & vehicle-user
          The creation of two tables will happen only when used ManyToMany annotations in both classes and not using attribute (mappedBy = "vehicleCollection")
          We have used (mappedBy = "vehicleCollection") annotation so mapping will be managed only by 1 table.
 */
    @Entity(name="usdt_mny_mny")
    @Table(name="usdt_mny_mny")
public class UserDetails {

    @Id
    private int userId;
    private String userName;
    @ManyToMany
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
