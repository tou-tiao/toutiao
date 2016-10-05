/*
 * 文章
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_article")
@DynamicInsert
@DynamicUpdate
@Getter @Setter
public class Article extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "exclusive_id", referencedColumnName = "id")
    private Exclusive exclusive;//用户的独家号

    @Column(length = 50, nullable = false, updatable = false)
    private String title;//文章的标题

    @Column(length = 50, nullable = false)
    private String url;//文章的地址

    @Column(name = "create_time", nullable = false, updatable = false)
    private Date createTime;//发布的时间

    @OneToMany(mappedBy = "user")
    @OrderBy(value = "id ASC")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @OrderBy(value = "id DESC")
    private Set<Collect> collects = new HashSet<>();

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

}