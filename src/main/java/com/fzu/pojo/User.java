/*
 * 用户
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "t_user")
@DynamicInsert
@Getter @Setter
public class User extends BaseModel {

    @Email
    @Size(max = 100)
    @Column(length = 100, unique = true, nullable = false)
    private String email;//邮箱，也是用户登录的账号

    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nick_name", length = 16)
    private String nickName;//昵称

    @NotNull
    @Size(min = 32, max = 32)
    @Column(length = 32, nullable = false)
    private String password;//密码

    @Size(max = 100)
    @Column(length = 100)
    private String avatar;//头像

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer role;//用户身份

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer status;//用户的状态

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer share;//用户分享的文章数

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer collect;//用户收藏的文章数

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer sub;//用户订阅的独家号数

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer attention;//用户关注的人数

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer fans;//用户的粉丝数

    @Column(nullable = false, columnDefinition = "DOUBLE default 0", precision = 12, scale = 1)
    private Double io;//用户的货币

    /*
     * @OneToOne注释指明User与UserInfo为一对一关系，
     * @OneToOne注释五个属性：targetEntity、cascade、fetch、optional和mappedBy
     */

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserInfo userInfo;//用户信息

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserLog userLog;//用户日志

    /*
     * @OneToMany: 指明User与Comment关联关系为一对多关系
     *
     * mappedBy: 定义类之间的双向关系。如果类之间是单向关系，不需要提供定义，如果类和类之间形成双向关系，我们就需要使用这个属性进行定义，
     * 否则可能引起数据一致性的问题。
     *
     * cascade: CascadeType[]类型。该属性定义类和类之间的级联关系。定义的级联关系将被容器视为对当前类对象及其关联类对象采取相同的操作，
     * 而且这种关系是递归调用的。举个例子：User和Comment有级联关系，那么删除User时将同时删除它所对应的Comment对象。
     * 而如果Comment还和其他的对象之间有级联关系，那么这样的操作会一直递归执行下去。cascade的值只能从CascadeType.PERSIST（级联新建）、
     * CascadeType.REMOVE（级联删除）、CascadeType.REFRESH（级联刷新）、CascadeType.MERGE（级联更新）中选择一个或多个。
     * 还有一个选择是使用CascadeType.ALL，表示选择全部四项。
     *
     * fatch: 可选择项包括：FetchType.EAGER 和FetchType.LAZY。前者表示关系类(本例是Comment类)在主类(本例是User类)加载的时候
     * 同时加载;后者表示关系类在被访问时才加载,默认值是FetchType.LAZY。
     */

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id DESC")//注释指明加载Comment时按id的降序排序
    private Set<Comment> comments;//用户的评论

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id DESC")
    private Set<Collect> collects;//用户的收藏

    @OneToMany(mappedBy = "ownUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "public_name ASC")
    private Set<Exclusive> ownExclusives;//用户拥有的独家号

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "t_subscribe",
            joinColumns = {@JoinColumn(name = "public_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "sub_id", nullable = false, updatable = false)}
    )
    @OrderBy(value = "public_name ASC")
    private Set<Exclusive> subExclusives;//用户订阅的独家号
}