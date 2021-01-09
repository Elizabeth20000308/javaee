package edu.njfu.sas.dao.impl;


import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.model.User;
import edu.njfu.sas.util.C3p0Util;
import edu.njfu.sas.util.Md5Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean checkUser(User user) {
        String sql="select*from tbl_user where username =? and password=?";
        long count=0;

        System.out.println(sql);

        QueryRunner queryRunner = new QueryRunner(C3p0Util.getConnection());
        try {
            Map<String, Object> map = queryRunner.query(sql, new MapHandler(),
                    new Object[]{user.getUsername(), new Md5Util().stringToMD5(user.getPassword())});
            count=(long)map.get("count");
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        return count>0;
    }

    @Override
    public boolean checkLogin(User user) throws SQLException {
        String sql="select count(*) as count from tbl_user where username =? and password=?";
        QueryRunner query = new QueryRunner(C3p0Util.getConnection());
        long count=0;
        try{
            Map<String, Object> map = query.query(sql, new MapHandler(),
                    new Object[]{user.getUsername(), Md5Util.stringToMD5(user.getPassword())});
            count=(long)map.get("count");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return count>0;
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        String sql="select*from tbl_user";
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getConnection());
        List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        System.out.println(users);
        return users;
    }

    @Override
    public boolean saveUser(User user) {
        String sql="insert into tbl_user (username,password) values(?,?)";
        int result=0;
        QueryRunner query = new QueryRunner(C3p0Util.getConnection());
        try {
            result = query.execute(sql, new Object[]{user.getUsername(), Md5Util.stringToMD5(user.getPassword())});
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result>0;
    }

    @Override
    public boolean getUser_by_username(String userName) {
        String sql="select count(*) as count from tbl_user where username =? ";
        QueryRunner query = new QueryRunner(C3p0Util.getConnection());
        long count=0;
        try{
            Map<String, Object> map = query.query(sql, new MapHandler(),
                    new Object[]{userName});
            count=(long)map.get("count");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return count>0;
    }
}
