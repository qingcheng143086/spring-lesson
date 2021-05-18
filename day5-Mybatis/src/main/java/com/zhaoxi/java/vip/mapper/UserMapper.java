package com.zhaoxi.java.vip.mapper;

import com.zhaoxi.java.vip.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;


public interface UserMapper {
    // 前面课程演示没有id原因是mybatis版本太低了
    /*配置全局的*/
    @Results(id = "userMap",value = {
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userGender",column = "user_gender"),
            @Result(property = "userBirthday",column = "user_birthday"),
    })

    List<User> queryAll();
    User queryById(Long userId);
    int insertUser(User user);
    int deleteById(Long userId);
    int updateById(User user);
    /////////////////////////////
//    List<User> queryUserByCondition(User user);
    List<User> queryUserByCondition(User user);

//    /*引用全家配置信息*/
//    @ResultMap(value = "userMap")
//    @Select({"<script>SELECT  `user_id`, `user_name`, `user_birthday`, `user_gender`\n" +
//            "        FROM user\n" +
//            "        WHERE user_id in\n" +
//            "        <foreach item=\"item\" index=\"index\" collection=\"list\"\n" +
//            "                 open=\"(\" separator=\",\" close=\")\">\n" +
//            "            #{item}\n" +
//            "        </foreach>\n" +
//            "   </script>"})
//    List<User> selectUserIn(List<Long> list);
    List<User> selectUserIn(List<Long> list);
}
