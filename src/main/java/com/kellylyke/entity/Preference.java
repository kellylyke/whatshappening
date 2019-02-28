package com.kellylyke.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Preference.
 */
@Entity(name = "Preference")
@Table(name = "user_preferences")
public class Preference {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "show_me")
    private String show;

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

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    private User user;


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets show.
     *
     * @return the show
     */
    public String getShow() {
        return show;
    }

    /**
     * Sets show.
     *
     * @param show the show
     */
    public void setShow(String show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Preference{" +
                "id=" + id +
                ", show='" + show + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference that = (Preference) o;
        return id == that.id &&
                Objects.equals(show, that.show) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, show, user);
    }
}
