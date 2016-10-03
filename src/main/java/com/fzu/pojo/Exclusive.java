/*
 * 独家号
 */
package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_exclusive")
@DynamicInsert
@Getter @Setter
public class Exclusive extends BaseModel {

    @Column(name = "public_name", unique = true, length = 16)
    private String publicName;//独家号的名称

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User ownUser;//表示该独家号的所有者

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer share;//该独家号下分享的文章数

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer subscriber;//订阅该独家号的人数

    @OneToMany(mappedBy = "exclusive", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id DESC")
    private Set<Article> shareArticles = new HashSet<Article>();//该独家号下分享的文章

    @ManyToMany(mappedBy = "subExclusives", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "nick_name ASC")
    private Set<User> subUser = new HashSet<User>();//表示订阅该独家号的用户

}