package lazy_load;


import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
/*
Scenario: Lazy loading i.e UserDetails object has a group of address associated.
                           Whenever you fetch data using session, only data in object will be fetched and Collection elements will
                           not be fetched unless you call the getter on that collection. This is called lazy loading
Lazyloading is by default in hibernate.
 */

    @Entity(name="userdet_lazy_load")
    @Table(name="userdet_lazy_load")
public class UserDetails {

    @Id

    private int userId;
    private String userName;
    @ElementCollection
    @JoinTable(name = "user_address_lazy",joinColumns = @JoinColumn(name = "user_id_lazy"))
    private Collection<Address> listAddress = new ArrayList<Address>();

    public Collection<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(Collection<Address> listAddress) {
        this.listAddress = listAddress;
    }

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



}
