package com.y0lo.service.role;

import com.y0lo.dao.BaseDao;
import com.y0lo.dao.role.RoleDao;
import com.y0lo.dao.role.RoleDaoImpl;
import com.y0lo.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class RoleServiceImpl implements RoleService{

    //引入Dao
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao=new RoleDaoImpl();
    }

    public List<Role> getRoleList() {
        Connection connection=null;
        List<Role> roleList=null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }

    @Test
    public void test(){
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
        }
    }

}
