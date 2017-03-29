package inheritance.discriminator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 21/8/15
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
/*
instead of having column dtype hibernate creates  column with name vehicle_type of type integer  and setting
discriminator value on all types of vehicle class would actually help to understand which class it is

If discriminator value is not set hibernate creates own data
 */
@Entity (name="veh_inh_single_disc")
@Table(name="veh_inh_single_disc")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("123")
public class Vehicle {
   @Id
   private int vid;
   private String vname;

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }
}
