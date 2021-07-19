package com.y0lo.test;

import org.junit.Test;

import java.sql.*;

public class Testjdbc3 {

    @Test
    public void test(){
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
        String username="root";
        String password="y0lo";

        Connection con =null;
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

        //2.连接数据库，con代表数据库
        con = DriverManager.getConnection(url, username, password);

        //3.通知数据库开启事务,false 开启
        con.setAutoCommit(false);

        String sql = "update account set money = money - 100 where name='A';";
        con.prepareStatement(sql).executeUpdate();

        //制造错误
        int i = 1/0;

        String sql2 = "update account set money = money + 100 where name='B';";
        con.prepareStatement(sql2).executeUpdate();

        con.commit();   //以上两条SQL 都执行成功了，就提交事务！
        System.out.println("success");
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
