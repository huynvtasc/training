package org.ngvhuy.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String username;
    private String password;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "modified_at")
    private Date modifiedAt;
}
