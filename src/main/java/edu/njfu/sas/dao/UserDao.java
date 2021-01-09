package edu.njfu.sas.dao;

import edu.njfu.sas.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public boolean checkUser(User user) throws SQLException;

    boolean checkLogin(User user) throws SQLException;

    List<User> getAllUser() throws SQLException;

    boolean saveUser(User user);
    boolean getUser_by_username(String userName);
}
