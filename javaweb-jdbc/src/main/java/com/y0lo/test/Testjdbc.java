package com.y0lo.test;

import java.sql.*;

public class Testjdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
        String username="root";
        String password="y0lo";

        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接数据库，con代表数据库
        Connection con = DriverManager.getConnection(url, username, password);

        //3.向数据库发送SQL的对象Statement   :CRUD
        Statement statement = con.createStatement();

        //4.编写SQL
        String sql="select * from users;";

        //5.执行查询SQL，返回一个ResultSet   :结果集
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }

        //6.关闭连接，释放资源（一定要做）先开后关
        resultSet.close();
        statement.close();
        con.close();


    }
}
