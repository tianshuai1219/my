package com.itheima.utils;

import com.sun.org.apache.bcel.internal.generic.DADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by admin on 2018/8/15.
 */
@Component
public class ConnectionUtils {
    ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource ds ;
    public Connection getC() throws Exception{
        if (tl.get()==null){
            Connection connection = ds.getConnection();
            tl.set(connection);
            return connection;
        }else {
            return tl.get();
        }
    }
}
