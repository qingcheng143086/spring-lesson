package org.example;

import com.zhaoxi.java.vip.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class MybatisTests extends AppTest {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        // 1、把xml文件转换为流对象
        Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
        // 2、通过流构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 3、获取建立与Mybatis交互对象SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        System.out.println("==============init================");
    }

    @Test
    public void testQueryUserById() throws Exception {
        // 肯定帮我们提供CRUD操作
        System.out.println(sqlSession);
        // 第一个参数：是映射文件唯一确定标识符字符串{命名空间+执行语句对应ID}
        // eg: test.queryUserById
        // 第二参数就是执行SQL语句参数值
        User user = (User) sqlSession.selectOne("test.queryUserById", 3L);
        System.out.println(user.getUserGender()+","+user.getUserName());
    }

    @After
    public void close() {
        System.out.println("============close============");
        sqlSession.close();
    }

}
