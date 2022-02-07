package com.y0lo.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutils {

    /* 使用Druid数据库连接池，获取数据库的连接 */
    private static DataSource source;
    static {
        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");

            pros.load(is);

            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {

        Connection conn = source.getConnection();
        return conn;
    }

    /* 使用DButils,关闭资源 */
    public static void closeResource(Connection conn, PreparedStatement psmt, ResultSet rs){
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(psmt);
        DbUtils.closeQuietly(rs);
    }
}
