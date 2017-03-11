package configure_collections;


import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
//@Entity
    @Entity(name="userdet_config_collc")
    @Table(name="userdet_config_collc")
public class UserDetails {

    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    @ElementCollection
    @JoinTable(name = "user_address",joinColumns = @JoinColumn(name = "user_id"))
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")},generator = "hilo-gen",type = @Type(type="long"))
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
