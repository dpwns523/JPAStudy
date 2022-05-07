package com.example.jpastudy.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id @GeneratedValue
    protected Long id;

    protected Boolean isDeleted;

    @CreationTimestamp
    @Column(updatable = false)
    protected Timestamp createdAt;

    @UpdateTimestamp
    protected Timestamp updatedAt;

    public BaseEntity() {
        this.isDeleted = false;
    }
}
