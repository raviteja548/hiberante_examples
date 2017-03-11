package mapping.one_many;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 16/8/15
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "vehcl_1_many")
public class Vehicle {
    @Id
    private int vid;
    private String vehicleName;

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
