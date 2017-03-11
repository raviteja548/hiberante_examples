package inheritance.discriminator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 21/8/15
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "twowheeler_disc")
//@DiscriminatorValue("1")
public class TwoWheeler extends Vehicle {
    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
