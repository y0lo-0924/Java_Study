package com.y0lo.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
 * 定义一个用来被继承的对数据库进行基本操作的Dao
 */
public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    // 定义一个变量来接收泛型的类型
    private Class<T> type;

    // 获取T的Class对象，获取泛型的类型，泛型是在被子类继承时才确定
    public BaseDao() {
        // 获取子类的类型
        Class clazz = this.getClass();
        // 获取父类的类型
        // getGenericSuperclass()用来获取当前类的父类的类型
        // ParameterizedType表示的是带泛型的类型
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        // 获取具体的泛型类型 getActualTypeArguments获取具体的泛型的类型
        // 这个方法会返回一个Type的数组
        Type[] types = parameterizedType.getActualTypeArguments();
        // 获取具体的泛型的类型·
        this.type = (Class<T>) types[0];
    }

    /* 通用的增删改操作 --- 考虑数据库事务 */
    public int update(Connection conn, String sql, Object... args) {
        int count = 0;
        try {
            count = queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /* 通用的查询操作(返回一个对象) --- 考虑数据库事务 */
    public T getBean(Connection conn, String sql, Object... args) {
        T t = null;
        try {
            //BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中
            t = queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    /* 通用的查询操作(返回多个对象) --- 考虑数据库事务 */
    public List<T> getBeanList(Connection conn, String sql, Object... args) {
        List<T> list = null;
        try {
            //BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /* 用于查询特殊值的通用方法 */
    public Object getValue(Connection conn, String sql, Object... args) {
        Object count = null;
        try {
            // 调用queryRunner的query方法获取一个单一的值
            //ScalarHandler:将结果集第一行的某一列放到某个对象中。
            count = queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
