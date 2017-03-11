package detach2persist;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
//@Entity
    @Entity(name="usdt_det2per")
    @Table(name="usdt_det2per")
    @org.hibernate.annotations.Entity(selectBeforeUpdate = true) //this annotation is used when update function is called(making obj from detached to persistant state only), update query will be
    //fired only when there is a change in object data that which is different from db. else update function will not be executed
public class UserDetails {

    @Id
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
