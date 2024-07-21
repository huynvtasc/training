package com.huynv.transaction.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String username;
    private String password;
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;
    @Column(name = "modified_at")
    @LastModifiedDate
    private Date modifiedAt;

    @PrePersist
    private void prePersist() {
        System.out.println("PrePersist....!!!");
    }

    @PreUpdate
    private void preUpdate() {
        System.out.println("PreUpdate....!!!");
    }

    @PreRemove
    private void preRemove() {
        System.out.println("PreRemove....!!!");
    }
}
