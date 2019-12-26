package com.zking.ssm.service;

import com.zking.ssm.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface ISysUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser listUserByName(String username);

    Set<String> listRolesByName(String username);

    Set<String> listPermissionByName(String username);
}