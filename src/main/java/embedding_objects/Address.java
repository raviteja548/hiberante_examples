package embedding_objects;

import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
// Embeddable annotation says that this object should be embedded in a object
@Embeddable
public class Address {
    private String doorNo;
    private String area;
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
