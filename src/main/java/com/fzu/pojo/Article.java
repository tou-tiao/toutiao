/*
 * 文章
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "t_article")
@Getter @Setter
public class Article extends BaseModel {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "public_name", referencedColumnName = "public_name")
    private Exclusive exclusive;//用户的公众号

    @Column(length = 50)
    private String title;//文章的标题

    @Column(length = 50)
    private String url;//文章的地址

    @Column(name = "create_time")
    private Timestamp createTime;//发布的时间

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id DESC")
    private Set<Collect> collects;

}