package test.Serlize;

import java.io.Serializable;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/1 13:39
 **/
public class User implements Serializable {
    private String name;
    private transient String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + getName() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
