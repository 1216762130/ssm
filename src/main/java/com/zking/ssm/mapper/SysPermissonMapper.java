package com.zking.ssm.mapper;

import com.zking.ssm.model.SysPermisson;

public interface SysPermissonMapper {
    int deleteByPrimaryKey(Integer perid);

    int insert(SysPermisson record);

    int insertSelective(SysPermisson record);

    SysPermisson selectByPrimaryKey(Integer perid);

    int updateByPrimaryKeySelective(SysPermisson record);

    int updateByPrimaryKey(SysPermisson record);
}