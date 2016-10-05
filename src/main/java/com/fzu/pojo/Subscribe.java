package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_subscribe")
@Getter @Setter
public class Subscribe extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "public_id", referencedColumnName = "id")
    private Exclusive exclusive;//独家号的id

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;//订阅者的id

}
