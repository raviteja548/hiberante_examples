package hql.named_query;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
//@Entity
    @Entity(name="usdt_name_query")
    //@NamedQuery(name = "queryUser.byId",query = "FROM usdt_name_query where userId = ?")
    @NamedNativeQuery(name = "queryUsers.byIds",query = "select * from usdt_name_query where userId = ?",resultClass = UserDetails.class)
    @Table(name="usdt_name_query")
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
