package com.libai.dao;

import com.libai.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有学生信息
     */
    @Select("select * from student")
    @Results(id = "studentMap",
            value = {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "sex",property = "sex"),
                    @Result(column = "score",property = "score"),
                    @Result(column = "birthday",property = "birthday"),
                    @Result(column = "address",property = "address"),
                    @Result(column = "id",
                            property = "accounts",
                            many = @Many(
                                    select = "com.libai.dao.AccountDao.findByStudentId",
                                    fetchType = FetchType.LAZY
                            ))
            })
    List<Student> findAll();

    /**
     * 根据id查询一个学生
     */
    @Select("select * from student where id = #{id}")
    @ResultMap("studentMap")
    Student findById(Integer id);

    /**
     * 保存操作
     */
    @Insert("insert into student(name,sex,score,birthday,address) values (#{name},#{sex},#{score},#{birthday},#{address})")
    @SelectKey(keyColumn="id",keyProperty="id",resultType=Integer.class,
            before =false, statement = { "select last_insert_id()" })
    int saveStudent(Student student);
    /**
     * 更新操作
     */
    @Update("update student set name=#{name},sex=#{sex},score=#{score},birthday=#{birthday},address=#{address} where id=#{id}")
    int updateStudent(Student student);

    /**
     * 删除操作
     */
    @Delete("delete from student where id = #{id}")
    int deleteStudent(Integer id);

    /**
     * 使用聚合函数
     */
    @Select("select count(*) from student")
    int findTotal();

    /**
     * 模糊查询
     */
    @Select("select * from student where name like #{name}")
    List<Student> findByName(Student student);
}
