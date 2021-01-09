package edu.njfu.sas.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbcpUtil {
    private  static BasicDataSource ds=null;
    static {
        //静态代码块属于类，用于对象的初始化，不属于对象
        Properties properties = new Properties();
        InputStream in = new DbcpUtil().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
        try{
            properties.load(in);
            ds= BasicDataSourceFactory.createDataSource(properties);
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public static BasicDataSource getDataSource() {
        return ds;
    }
}
