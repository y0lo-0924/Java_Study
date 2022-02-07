package com.y0lo.dao.user;

import com.mysql.cj.util.StringUtils;
import com.y0lo.dao.BaseDao;
import com.y0lo.pojo.Role;
import com.y0lo.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?;";
//            System.out.println(sql);
            Object[] params = {userCode};
            //System.out.println(userPassword);
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
            if (!user.getUserPassword().equals(userPassword))
                user = null;
        }
        return user;
    }

    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        System.out.println("UserDaoImpl:" + password);
        PreparedStatement pstm = null;
        int execute = 0;
        if (connection != null) {
            String sql = "update smbms_user set userPassword = ? where id = ?;";
            Object params[] = {password, id};
            System.out.println(sql);
            execute = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return execute;
    }

    public int getUserCount(Connection connection, String username, int userRole) throws SQLException {
        //根据用户名或者角色查询用户总数

        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;

        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();//存放我们的参数

            if (!StringUtils.isNullOrEmpty(username)) {
                sql.append(" and u.userName like ?");
                list.add("%" + username + "%"); //index:0
            }

            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole); //index:1
            }

            //怎么把List转换为数组
            Object[] params = list.toArray();

            System.out.println("UserDaoImpl->getUserCount:" + sql.toString()); //输出最后完整的SQL语句


            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);

            if (rs.next()) {
                count = rs.getInt("count"); //从结果集中获取最终的数量
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return count;
    }

    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        //在数据库中，分页使用 limit startIndex,pageSiez; 总数
        //当前页起始记录数    (当前页-1)*页面大小
        //0,5      1   0
        //6,5      2   5
        //11,5     3   10
        //根据用户名或者角色查询用户总数

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();

        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();

            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%" + userName + "%"); //index:0
            }

            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole); //index:1
            }
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo - 1) * pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            //怎么把List转换为数组
            Object[] params = list.toArray();
            System.out.println("UserDaoImpl->getUserList:" + sql.toString()); //输出最后完整的SQL语句


            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);

            while (rs.next()) {
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userList;
    }
}