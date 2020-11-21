package com.libai.test;

import com.libai.dao.StudentDao;
import com.libai.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class StudentAnnotationTest {
    String resource = "mybatis-config.xml";
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    StudentDao studentDao;

    /**
     * 查询所有学生信息
     */
    @Test
    public void testFindAll(){
        List<Student> students = studentDao.findAll();
        //for (Student student:students) System.out.println(student);
    }

    /**
     * 查询记录总数
     */
    @Test
    public void testFindTotal() {
        int res = studentDao.findTotal();
        System.out.println(res);
    }

    /**
     * 根据姓名模糊查询一个学生
     */
    @Test
    public void testFindStudentByName() {
        Student student = new Student();
        student.setName("%李%");
        List<Student> list = studentDao.findByName(student);
        for (Student s : list) {
            System.out.println(s);
        }
    }

    /**
     * 删除一条学生信息
     */
    @Test
    public void testDel() {
        int res = studentDao.deleteStudent(7);
        System.out.println(res);
    }

    /**
     * 更新一条学生信息
     */
    @Test
    public void testUpdate() {
        Student student = studentDao.findById(1);
        student.setName("李白");
        int res = studentDao.updateStudent(student);
        System.out.println(res);
    }

    /**
     * 新增一条学生信息
     */
    @Test
    public void testSave() {
        Student s = new Student("刘云", 0, 75d, new Date(), "湖北省孝感市");
        System.out.println(studentDao.saveStudent(s));
    }

    /**
     * 根据id查询一个学生信息
     */
    @Test
    public void testFindOne() {
        Student student1 = studentDao.findById(1);
        System.out.println("第一次查询"+student1);
        student1.setScore(97d);
        studentDao.saveStudent(student1);
        Student student2 = studentDao.findById(1);
        System.out.println("第二次查询"+student2);
    }

    @Before //test方法执行之前要执行的方法
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        studentDao = session.getMapper(StudentDao.class);
    }

    @After //test方法执行之后要执行的方法
    public void destroy() throws IOException {
        session.commit();
        //释放资源
        session.close();
        inputStream.close();
    }
}
