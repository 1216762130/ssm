package com.zking.ssm.mapper;

import com.zking.ssm.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SysUserMapper {
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