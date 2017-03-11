package attribute_overrides_embedded_objects;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
//@Entity
    @Entity(name="userdet_attrib_embedobj")
    @Table(name="userdet_attrib_embedobj")
public class UserDetails {

    @Id @GeneratedValue
    private int userId;
    private String userName;
    @Embedded
    private Address homeAddress;

    // The follwing column names for officeAdress shall be overridden on the actual names
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "doorNo",column = @Column(name = "office_doorNo")),
        @AttributeOverride(name = "area",column = @Column(name = "office_area")),
        @AttributeOverride(name = "city",column = @Column(name = "office_city"))

    })
    private Address officeAddress;



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName+""+userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }
}
