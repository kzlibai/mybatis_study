package com.libai.dao;

import com.libai.pojo.Student;

import java.util.List;

/**
 * StudentDao就是持久层接口，也可以写成StudentMapper
 */
public interface StudentDao {
    /**
     * 查询所有学生信息
     *
     * @return 学生信息列表
     */
    List<Student> findAll();

    /**
     * 根据id查询学生信息
     * @return 返回一个学生
     */
    Student selectOne(Integer id);
}
