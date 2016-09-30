/*
 * 用户日志
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_user_log")
@Getter @Setter
public class UserLog extends BaseModel {

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;//用户的id

    @Column(length = 50)
    private String action;//用户的行为

    @Column(length = 50)
    private String ip;//登录的ip地址

    @Column(name = "create_time")
    private Timestamp createTime;//发生行为的时间

    @Lob
    @Column()
    private String content;//用户的评论

}