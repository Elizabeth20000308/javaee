package edu.njfu.sas.test;
import edu.njfu.sas.dao.*;
import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User;

import java.io.IOException;
import java.sql.SQLException;


public class Test {
    public  static  void main(String arg[]) throws IOException, SQLException {
//        Student s=new Student("180204208","刘墨羽","1802042","男",
//                "生物工程","15950761018","10123","./images/student/boy.jpg");
//        System.out.print(new StudentDaoImpl().countToString());
//        Properties properties = new Properties();
//        InputStream in=new Test().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
//        properties.load(in);
//        System.out.println(properties.getProperty("password"));
//        System.out.println(properties.getProperty("url"));
//        properties.setProperty("username2","sjy");
//        System.out.println(properties.getProperty("username2"));


        ///getConnection()会抛出异常
//        1由调用者处理
//        2处理不了，继续抛
//        System.out.println(DbcpUtil.getDataSource() == null);
//        System.out.println(DbcpUtil.getDataSource().getConnection() == null);


//        System.out.println(C3p0Util.getConnection() == null);
//        System.out.println(new StudentDaoImp2().getAllStudent());
//        System.out.println(new StudentDaoImp2().countToString());
//        System.out.println(new StudentDaoImp2().getStudentByPage(1,2));


        UserDao userDao = new UserDaoImpl();
        User userDao1 = new User("zhangsan","12345");
        userDao.checkUser(userDao1);
    }
}
