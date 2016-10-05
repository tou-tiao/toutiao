package com.fzu.pojo;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(Object other) {
        return !(other == null || other.getClass() != this.getClass())
                && !(this.getId() == null || ((BaseModel) other).getId() == null)
                && this.getId().equals(((BaseModel) other).getId());
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }

}
