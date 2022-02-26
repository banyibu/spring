package com.banyibu.springboot01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot01ApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看默认数据源
        System.out.println(dataSource.getClass());

        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        // XXX Template :springboot 已经配好的模版bean，拿来即用；

    }

}
