package com.y0lo.dao.role;

import com.y0lo.pojo.Role;

import java.sql.Connection;
import java.util.List;
import java.sql.SQLException;

public interface RoleDao {
    //获取角色列表
    public List<Role> getRoleList(Connection connection) throws SQLException;
}
