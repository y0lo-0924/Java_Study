package com.y0lo.pojo;

import java.util.Date;

public class Role {
    private Integer id; //id
    private String roleCode;    //角色编码
    private String roleName;    //角色名称
    private Integer createdBy;  //创建这
    private Date creationDate;  //创建时间
    private Integer modifyBy;   //更新者
    private Date modifyDate;    //更新时间

    public Integer getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
