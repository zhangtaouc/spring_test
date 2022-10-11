package config.User;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private int id;
    private Date birthday;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                '}';
    }

//    public User( int id, String username, String password, Date birthday) {
//        this.username = username;
//        this.password = password;
//        this.id = id;
//        this.birthday = birthday;
//    }
}
