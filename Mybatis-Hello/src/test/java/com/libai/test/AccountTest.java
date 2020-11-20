package com.libai.test;

import com.libai.dao.AccountDao;
import com.libai.pojo.Account;
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

public class AccountTest {
    String resource = "mybatis-config.xml";
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    AccountDao accountDao;

    @Test
    public void testFindAll(){
        List<Account> list = accountDao.findAll();
        for (Account as:list) System.out.println(as);
    }

    @Before //test方法执行之前要执行的方法
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        accountDao = session.getMapper(AccountDao.class);
    }

    @After //test方法执行之后要执行的方法
    public void destroy() throws IOException {
        session.commit();
        //释放资源
        session.close();
        inputStream.close();
    }
}
