package com.libai.test;

import com.libai.dao.StudentDao;
import com.libai.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试Mybatis环境
 */
public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从sqlSessionFactory中获取SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> studentList = mapper.findAll();
            Student student = mapper.selectOne(1);
            System.out.println(studentList);
            System.out.println(student);
        }
    }
}
