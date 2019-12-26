package com.zking.ssm.model;

public class SysRolePermisson {
    private Integer roleid;

    private Integer perid;

    public SysRolePermisson(Integer roleid, Integer perid) {
        this.roleid = roleid;
        this.perid = perid;
    }

    public SysRolePermisson() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }
}