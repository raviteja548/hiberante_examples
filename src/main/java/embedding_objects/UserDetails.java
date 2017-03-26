package embedding_objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
//@Entity
    @Entity(name="userdetails_embedding_objects")
    @Table(name="userdetails_embedding_objects")
public class UserDetails {

    @Id @GeneratedValue
    private int userId;
    private String userName;
    //This annotation helps to embed the fields present in address object to userdetails object
    @Embedded     // This annotation here is not mandatory if we marked the class Address with @Embeddable annotation.
    private Address address;




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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
