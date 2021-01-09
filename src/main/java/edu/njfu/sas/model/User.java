package edu.njfu.sas.model;

public class User {
    private String username;
    private String password;
    private String stuno;
    private int type;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStuno() {
        return stuno;
    }

    public int getType() {
        return type;
    }


}
