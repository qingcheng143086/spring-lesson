package org.example;

import com.zhaoxi.java.vip.mapper.UserMapper;
import com.zhaoxi.java.vip.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MybatisCRUDTests extends AppTest {
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testInsertUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        /*User user = User.builder().userName("gerry").
                userGender("男").
                userBirthday(new Date()).build();*/
        User user = new User();
        user.setUserName("gerry");
        user.setUserGender("男");
        user.setUserBirthday(new Date());
        int row = mapper.insertUser(user);

        System.out.println(row > 0 ? "成功" : "失败");
    }

    @Test
    public void testDeleteUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int row = mapper.deleteById(1006L);

        System.out.println(row > 0 ? "成功" : "失败");
    }

    @Test
    public void testUpdateUser() {
        // 先查询
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryById(1012L);
        user.setUserGender("女");
        user.setUserName("new Data");
        int row = mapper.updateById(user);
        System.out.println(row > 0 ? "成功" : "失败");
    }

    @Test
    public void testQueryAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryAll();
        users.forEach(user -> {
            System.out.println(user.getUserId()+","+user.getUserName());
        });
    }

//    @Test // 测试动态SQL
//    public void testDyQueryByCondition() {
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = new User();
//        user.setUserGender("男");
//        user.setUserName("g");
//        List<User> users = mapper.queryUserByCondition(user);
//        for (User u : users) {
//            System.out.println(u.getUserId()+","+u.getUserName());
//        }
//    }

//    /*测试In子查询*/
//    @Test
//    public void testInQuery() {
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.selectUserIn(Arrays.asList(1L, 2L, 3L));
//        users.forEach(user -> {
//            System.out.println(user.getUserId()+","+user.getUserName());
//        });
//    }

@Test
public void testInQuery(){
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List<User> users = mapper.selectUserIn(Arrays.asList(1L, 2L));
    users.forEach(user -> {
        System.out.println(user.getUserId()+","+user.getUserName());
    });
}
//测试 动态sql
    @Test
    public void test1(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user =new User();
        user.setUserName("张三");
        user.setUserId(1L);
        List<User> users = mapper.queryUserByCondition(user);
        users.forEach(user1 -> {
            System.out.println(user1.getUserId()+","+user1.getUserName());
        });
    }
    @After
    public void close() {
        // 在这里必须手动提交，因为交给了Mybatis来管理事务
        sqlSession.commit();
        sqlSession.close();
    }
}
