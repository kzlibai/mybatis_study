package com.libai.dao;

import com.libai.pojo.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户，同时获取账户的所属用户名称以及它的地址信息
     * @return 账户信息和所属学生信息的列表
     */
    List<Account> findAll();
}
