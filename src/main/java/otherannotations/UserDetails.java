package otherannotations;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
    //@Table annotation: name attribute is used to create table with the name specified in db
    //@Entity annotation: name attribute is just called only when using hql, you query on basis of entity rather than table name
    @Entity(name="usdt_annot")
    @Table(name="usdt_annot")
public class UserDetails {

    @Id
    private int userId;
    @Column(name="uname")
    private String userName;
    //Temporal is an annotation that is used to specify a column to store date/timestamp etc pass enum value
    // by default hibernate stores date and time
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    //using transient annotation will not store column into db.
    @Transient
    private String address;
    // if Lob annotation is on top of string it stores as clob, use this annotation when you store huge data
    //@Lob
    private String description;

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

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
