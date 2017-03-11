package mapping.many_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 16/8/15
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "vehcl_mny_mny")
public class Vehicle {
    @Id
    private int vid;
    private String vehicleName;
    @ManyToMany(mappedBy = "vehicleCollection")     // if u dont include mapped by vehicle collection, hibernate creates two tables that maintains maping in user & vehicle tables.
    private Collection<UserDetails> userDetailsList = new ArrayList<UserDetails>();

    public Collection<UserDetails> getUserDetailsList() {
        return userDetailsList;
    }

    public void setUserDetailsList(Collection<UserDetails> userDetailsList) {
        this.userDetailsList = userDetailsList;
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
