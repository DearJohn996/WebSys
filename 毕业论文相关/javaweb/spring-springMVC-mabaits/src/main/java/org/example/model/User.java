package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户表
 */
@Getter
@Setter
@ToString
public class User {
    
    private Integer id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像url
     */
    private String head;

    /**
     * 创建时间
     */
    private Date createTime;




    /**
     * 因为设置id中包含其他表的详细数据  将设置id加入后方便用户表管理其他表
     */
    private Integer settingId;
}