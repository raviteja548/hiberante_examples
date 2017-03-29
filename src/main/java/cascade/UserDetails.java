package cascade;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
Scenario: when object is referenced in any other object with having one-one/one-many/ any, it is not necessary to save referenced objects,
            instead use CascadeType.ALL This scenario will be used when you have many references or a list of objects in a class.

 */
    @Entity(name="usdt_cascade")
    @Table(name="usdt_cascade")
public class UserDetails {

    @Id
    private int userId;
    private String userName;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Vehicle vehicle = new Vehicle();

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
