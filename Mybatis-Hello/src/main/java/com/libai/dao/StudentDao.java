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
     * @param id 根据id查询学生信息
     * @return 返回一个学生
     */
    Student selectOne(Integer id);

    /**
     * 新增一个学生
     *
     * @param student 新增学生的信息
     * @return 影响数据库记录的行数
     */
    int saveStudent(Student student);

    /**
     * 更新学生
     *
     * @param student 更新的用户
     * @return 影响数据库记录的行数
     */
    int updateStudent(Student student);

    /**
     * 删除学生
     *
     * @param id 删除的学生的id
     * @return 影响数据库记录的行数
     */
    int delStudent(Integer id);

    /**
     * 根据姓名模糊查询
     *
     * @param student 将要查询的信息传递给student对象
     * @return 查询到的学生信息的列表
     */
    List<Student> findStudentByName(Student student);

    /**
     * 查询总数
     *
     * @return 记录总数
     */
    int findTotal();
}
