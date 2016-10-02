/*
 * 评论
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_comment")
@DynamicInsert
@Getter @Setter
public class Comment extends BaseModel {

    /*
     * @ManyToOne指明Comment和User之间为多对一关系，多个Comment实例关联的都是同一个User对象。
     * 其中的属性和@OneToMany基本一样，但@ManyToOne注释的fetch属性默认值是FetchType.EAGER。
     *
     * optional属性是定义该关联类对是否必须存在，值为false时，关联类双方都必须存在，如果关系被维护端不存在，查询的结果为null。
     * 值为true时, 关系被维护端可以不存在，查询的结果仍然会返回关系维护端，在关系维护端中指向关系被维护端的属性为null。
     * optional属性的默认值是true。举个例：某项订单(Order)中没有订单项(OrderItem)，如果optional属性设置为false，
     * 获取该项订单(Order)时，得到的结果为null，如果optional属性设置为true，仍然可以获取该项订单，但订单中指向订单项的属性为null。
     * 实际上在解释Order与OrderItem的关系成SQL时，optional属性指定了他们的联接关系optional = false联接关系为inner join,
     * optional = true联接关系为left join。
     *
     * @JoinColumn:指明了被维护端(Comment)的外键字段为user_id，它和维护端(User)的主键(id)连接，unique = true指明user_id列的值不可重复。
     */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;//评论的用户的id

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;//文章的id

    @Lob
    @Column()
    private String context;//评论的内容

    @Column(name = "comment_time")
    private Date commentTime;//收藏文章的时间

    @PrePersist
    public void prePersist(){
        commentTime = new Date();
    }

}