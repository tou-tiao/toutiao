/*
 * 用户信息
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user_info")
@DynamicInsert
@Getter @Setter
public class UserInfo extends BaseModel {

    /*
     * @OneToOne注释指明User与UserInfo为一对一关系，
     * @OneToOne注释五个属性：targetEntity、cascade、fetch、optional和mappedBy
     * @OneToOne注释指明IDCard与Person为一对一关系，
     * IDCard是关系被维护端，optional = false设置person属性值不能为null，
     * 也就是身份证必须有对应的主人。
     * @JoinColumn(name = "Person_ID", referencedColumnName ="personid",unique = true)
     * 指明IDCard对应表的Person_ID列作为外键与
     * Person对应表的personid列进行关联,unique= true 指明user_id列的值不可重复。
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;//用户的id

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

    @Column(name = "create_time")
    private Date createTime;//用户创建时间

    @Column(name = "update_time")
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