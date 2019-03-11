package com.kellylyke.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Objects;

/**
 * The type Preference.
 */
@Entity(name = "Preference")
@Table(name = "user_preferences")
@Data
public class Preference {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "show_me")
    private String show;

    @ManyToOne
    private User user;

    /**
     * Empty constructor
     */
    public Preference() {

    }

    /**
     * Instantiates a new Preference.
     *
     * @param show the show
     * @param user the user
     */
    public Preference(String show, User user) {
        this.user = user;
        this.show = show;
    }


/*
    @Override
    public String toString() {
        return "Preference{" +
                "id=" + id +
                ", show='" + show + '\'' +
                ", user=" + user +
                '}';
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference that = (Preference) o;
        return id == that.id &&
                Objects.equals(show, that.show) &&
                Objects.equals(user, that.user);
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(id, show, user);
    }*/
}
