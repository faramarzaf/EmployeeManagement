package com.spring.web.app.EmployeeManagementWebApp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * UniqueConstraint allows you to name the constraint, while @Column(unique = true) generates a random name (e.g. UK_3u5h7y36qqa13y3mauc5xxayq).
 *
 * @Column(unique = true) -->This code implies that both mask and group have to be unique, but separately.
 * That means that if, for example, you have a record with a mask.id = 1 and tries to insert another record with mask.id = 1,
 * you'll get an error, because that column should have unique values.
 * <p>
 * UniqueConstraint--> Implies that the values of mask + group combined should be unique.
 * That means you can have, for example, a record with mask.id = 1 and group.id = 1, and if you try to insert another record with mask.id = 1 and group.id = 2,
 * it'll be inserted successfully, whereas in the first case it wouldn't.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;


    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


}
