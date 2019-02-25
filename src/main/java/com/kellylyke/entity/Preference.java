package com.kellylyke.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
}
