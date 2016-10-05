/*
 * 用户日志
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_userlog")
@DynamicInsert
@DynamicUpdate
@Getter @Setter
public class UserLog extends BaseModel {

    @Column(name = "user_id")
    private Long userId;//用户的id

    @Column(length = 50)
    private String action;//用户的行为

    @Column(length = 50)
    private String ip;//登录的ip地址

    @Column(name = "create_time", nullable = false, updatable = false)
    private Date createTime;//发生行为的时间

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

}