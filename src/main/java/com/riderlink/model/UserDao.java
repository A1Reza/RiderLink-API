package com.riderlink.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "APP_USER",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_app_user_username",
                        columnNames = "username"
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*
 * We use @Table(uniqueConstraints = ...) to define a named
 * database-level unique constraint instead of relying on a simple
 * column-level unique declaration.
 *
 * APP_USER is used instead of USER because USER is a special SQL
 * keyword in PostgreSQL and APP_USER avoids potential naming conflicts.
 */
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, length = 15)
    private String phone;
}
