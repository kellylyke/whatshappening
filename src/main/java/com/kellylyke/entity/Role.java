package com.kellylyke.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


/**
 * User's Role
 */
@Data
@Entity(name = "Role")
@Table(name = "user_roles") // case sensitive!
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role")
    private String role;

    @Column(name = "created")
    @EqualsAndHashCode.Exclude
    private Date dateCreated;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="username", referencedColumnName = "username", nullable = false)
    @EqualsAndHashCode.Exclude
    private User user;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", dateCreated=" + dateCreated +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id &&
                role.equals(role1.role) &&
                Objects.equals(dateCreated, role1.dateCreated);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, dateCreated);
    }


}