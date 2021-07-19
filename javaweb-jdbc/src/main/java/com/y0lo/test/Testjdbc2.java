package com.y0lo.test;

import java.sql.*;

public class Testjdbc2 {
    public static void main(String[] args) throws Exception {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
        String username="root";
        String password="y0lo";

        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库，con代表数据库
        Connection con = DriverManager.getConnection(url, username, password);

        //3.编写SQL
        String sql="insert into users(id,name,password,email,birthday) value (?,?,?,?,?)";

        //4.预编译
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1,4);  //给第一个占位符?  的值赋值为1；
        preparedStatement.setString(2,"y0lo");  //给第二个占位符?  的值赋值为1；
        preparedStatement.setString(3,"123456");  //给第三个占位符?  的值赋值为1；
        preparedStatement.setString(4,"y0lo@qq.com");  //给第四个占位符?  的值赋值为1；
        preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));  //给第五个占位符?  的值赋值为1；

        //5.执行SQL
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("插入成功");
        }

        //6.关闭连接，释放资源（一定要做）先开后关
        preparedStatement.close();
        con.close();


    }
}
