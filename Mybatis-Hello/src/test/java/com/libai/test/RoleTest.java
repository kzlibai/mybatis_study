package com.libai.test;

import com.libai.dao.RoleDao;
import com.libai.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleTest {
    String resource = "mybatis-config.xml";
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    RoleDao roleDao;

    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles){
            System.out.println(role);
        }
    }

    @Before //test方法执行之前要执行的方法
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        roleDao = session.getMapper(RoleDao.class);
    }

    @After //test方法执行之后要执行的方法
    public void destroy() throws IOException {
        session.commit();
        //释放资源
        session.close();
        inputStream.close();
    }
}
