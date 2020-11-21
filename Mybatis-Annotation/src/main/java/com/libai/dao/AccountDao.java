package com.libai.dao;

import com.libai.pojo.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有用户，采用延迟加载的方式查询账户的所属学生
     */
    @Select("select * from account")
    @Results(id = "accountMap",
            value = {
                @Result(id = true,column = "id",property = "id"),
                @Result(column = "studentId",property = "studentId"),
                @Result(column = "money",property = "money"),
                @Result(column = "studentId",
                        property = "student",
                        one = @One(select = "com.libai.dao.StudentDao.findById",
                        fetchType = FetchType.LAZY))
            })
    List<Account> findAll();

    @Select("select * from account where studentId = #{id}")
    List<Account> findByStudentId(Integer studentId);
}
