/*
 * 收藏文章
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_collect")
@Getter @Setter
public class Collect extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;//收藏文章的用户的id

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;//文章的id

    @Column(name = "collect_time", nullable = false, updatable = false)
    private Date collectTime;//收藏文章的时间

    @PrePersist
    public void prePersist(){
        collectTime = new Date();
    }

}