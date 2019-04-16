package com.tuxiaoer.shanghai.modules.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/4 9:46
 * @description：系统用户实体
 */
@Data
public class User implements Serializable {

    /**
     * 用户ID（主键）
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 头像
     */
    private String headImage;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 新增属性用于：用户保存并保存角色
     */
    @JsonIgnore
    private List<Integer> roleIds;

    /**
     * 角色
     */
    private List<Role> roles = new ArrayList<>();

}
