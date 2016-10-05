/*
 * 独家号
 */
package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_exclusive")
@DynamicInsert
@DynamicUpdate
@Getter @Setter
public class Exclusive extends BaseModel {

    @Column(name = "public_name", length = 16, unique = true)
    private String publicName;//独家号的名称

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;//该独家号的所有者

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer share;//该独家号下分享的文章数

    @Column(nullable = false, columnDefinition = "INT default 0")
    private Integer subscriber;//订阅该独家号的人数

    @OneToMany(mappedBy = "exclusive")
    @OrderBy(value = "id DESC")
    private Set<Article> articles = new HashSet<>();//该独家号下分享的文章

    @OneToMany(mappedBy = "user")
    @OrderBy(value = "user_id ASC")
    private Set<Subscribe> subscribes = new HashSet<>();//订阅该独家号的用户

}