package com.zhaoxi.java.vip.mybatis.mapper;

import com.zhaoxi.java.vip.mybatis.pojo.User;

public interface UserMapper {
    /**
     * 注意： 该接口中的方法必须和对应Mapper映射文件中配置查询语句ID要匹配
     * @param userId
     * @return
     */
    User queryUserById(Long userId);
}
