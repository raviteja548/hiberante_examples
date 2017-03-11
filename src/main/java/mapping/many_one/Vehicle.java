package mapping.many_one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 16/8/15
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "vehcl_many_1")
public class Vehicle {
    @Id
    private int vid;
    private String vehicleName;
    @ManyToOne
    @JoinColumn(name = "us_vid")
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
