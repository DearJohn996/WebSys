package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 抽奖设置
 */
@Getter
@Setter
@ToString
public class Setting {
    
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 每次抽奖人数
     */
    private Integer batchNumber;

    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 该数据组织高于原数据表内容，将其他表内容（基于已有查询到的数据对象）选择性的加入，
     * 使得setting表数据更多，方便业务
     */
    private User user;

    private List<Award> awards;

    private List<Member> members;
}