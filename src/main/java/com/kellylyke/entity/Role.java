package com.kellylyke.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


/**
 * User's Role
 */
@Data
@Entity(name = "Role")
@Table(name = "user_roles") // case sensitive!
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private String role;

    @Column(name = "created")
    @EqualsAndHashCode.Exclude private Date dateCreated;


    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username", nullable = false)    // referenceColumnName if not primary key
    private User user;



}