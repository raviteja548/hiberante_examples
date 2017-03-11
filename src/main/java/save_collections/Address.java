package save_collections;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class Address {
    @Column(name = "home_doorNo")
    private String doorNo;
    @Column(name = "home_area")
    private String area;
    @Column(name = "home_city")
    private String city;

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
