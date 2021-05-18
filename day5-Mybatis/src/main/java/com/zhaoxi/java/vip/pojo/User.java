package com.zhaoxi.java.vip.pojo;

import java.util.Date;

/**
 * 快速生成User实体类中setter和getter方法的插件lombok
 * 1、在idea中安装lombok插件
 * 2、File | Settings | Build, Execution, Deployment | Compiler | Annotation Processors进行勾选
 * 3、在项目中引入lombok插件
 * com.zhaoxi.java.vip.mybatis.pojo.User
 */
//@Builder
//@Setter
//@Getter
//@NoArgsConstructor // 无参数构造函数
public class User {
    private Long userId;
    private String userName;
    private String userGender;
    private Date userBirthday;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}
