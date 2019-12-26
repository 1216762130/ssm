package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.SysUserMapper;
import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return 0;
    }

    @Override
    public int insert(SysUser record) {
        return 0;
    }

    @Override
    public int insertSelective(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByPrimaryKey(Integer userid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return 0;
    }

    @Override
    public SysUser listUserByName(String username) {
        return sysUserMapper.listUserByName(username);
    }

    @Override
    public Set<String> listRolesByName(String username) {
        return sysUserMapper.listRolesByName(username);
    }

    @Override
    public Set<String> listPermissionByName(String username) {
        return sysUserMapper.listPermissionByName(username);
    }
}
