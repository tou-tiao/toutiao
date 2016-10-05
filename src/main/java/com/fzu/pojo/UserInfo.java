/*
 * 用户信息
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_userinfo")
@DynamicInsert
@DynamicUpdate
@Getter @Setter
public class UserInfo {

    @Id
    @Column(name = "user_id", updatable = false)
    private Long userId;//主键，与用户表一致

    @Column(length = 50)
    private String city;//用户所在的城市

    @Column(length = 50)
    private String blog;//用户的博客

    @Column(length = 50)
    private String github;//用户的github地址

    @Column(length = 50)
    private String weixin;//用户的微信

    @Column(length = 50)
    private String jobs;//用户的职业

    @Column(name = "create_time", nullable = false, updatable = false)
    private Date createTime;//用户创建时间

    @Column(name = "update_time", nullable = false)
    private Date updateTime;//用户修改时间

    @PrePersist
    public void prePersist(){
        createTime = updateTime = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        updateTime = new Date();
    }

}