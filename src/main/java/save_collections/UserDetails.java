package save_collections;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 15/8/15
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
/*
Scenario: to add list of address into db. for 1 user add 'n' addresses.
          creates 2 tables, 1. userdetails 2. Table to store addresses , foreign key in address table will be prim key of userdetails
 */
    @Entity(name="userdet_save_coll")
    @Table(name="userdet_save_coll")
public class UserDetails {

    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    @ElementCollection
    private Set<Address> listAddress = new HashSet<Address>();

    public Set<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(Set<Address> listAddress) {
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
