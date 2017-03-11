package inheritance.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 21/8/15
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "inh_fw_tableperclass")
@Table(name = "inh_fw_tableperclass")
public class FourWheeler extends Vehicle {
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
