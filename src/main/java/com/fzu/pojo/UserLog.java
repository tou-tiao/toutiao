/*
 * 用户日志
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user_log")
@DynamicInsert
@Getter @Setter
public class UserLog extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;//用户的id

    @Column(length = 50)
    private String action;//用户的行为

    @Column(length = 50)
    private String ip;//登录的ip地址

    @Column(name = "create_time")
    private Date createTime;//发生行为的时间

    @Lob
    @Column()
    private String content;//用户的评论

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

}