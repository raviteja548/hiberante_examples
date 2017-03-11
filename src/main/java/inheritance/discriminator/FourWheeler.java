package inheritance.discriminator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 21/8/15
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "fourwheeler_disc")
//@DiscriminatorValue("2")
public class FourWheeler extends Vehicle {
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
