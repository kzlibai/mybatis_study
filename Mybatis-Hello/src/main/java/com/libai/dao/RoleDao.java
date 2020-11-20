package com.libai.dao;

import com.libai.pojo.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色
     * @return 所有角色信息的列表
     */
    List<Role> findAll();
}
