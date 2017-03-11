package inheritance.singletablestatergy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 21/8/15
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="veh_inh_single")
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
