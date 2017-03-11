package eager_loading;


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
//@Entity
    @Entity(name="userdet_eager_load")
    @Table(name="userdet_eager_load")
public class UserDetails {

    @Id

    private int userId;
    private String userName;
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "user_address_eager",joinColumns = @JoinColumn(name = "user_id_eager"))
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
