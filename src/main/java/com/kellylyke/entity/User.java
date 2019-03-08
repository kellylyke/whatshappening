package com.kellylyke.entity;

import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * A class to represent a user.
 *
 * @author klyke
 */
@Data
@Entity(name = "Users")
@Table(name = "users") // case sensitive!
public class User implements Serializable {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "zipcode")
    private int zipcode;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Preference> preferences = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles = new HashSet<>();




/**
     * Instantiates a new User.
     */

    public User() {
    }


/**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param username  the user name
     * //@param id        the id
     * @param zipcode   the zipcode
     * @param email     the email address
     * @param password  user password
     */

    public User(String firstName, String lastName, String username, int zipcode, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.id = id;
        this.zipcode = zipcode;
        this.email = email;
        this.password = password;
    }



/**
     * Gets first name.
     *
     * @return the first name
     *//*

    public String getFirstName() {
        return firstName;
    }

    */
/**
     * Sets first name.
     *
     * @param firstName the first name
     *//*

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    */
/**
     * Gets last name.
     *
     * @return the last name
     *//*

    public String getLastName() {
        return lastName;
    }

    */
/**
     * Sets last name.
     *
     * @param lastName the last name
     *//*

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    */
/**
     * Gets user name.
     *
     * @return the user name
     *//*

    public String getUsername() {
        return username;
    }

    */
/**
     * Sets user name.
     *
     * @param username the user name
     */

    public void setUsername(String username) {
        this.username = username;
    }


/**
     * Gets id.
     *
     * @return the id
     *//*

    public int getId() {
        return id;
    }

    */
/**
     * Sets id.
     *
     * @param id the id
     *//*

    public void setId(int id) {
        this.id = id;
    }

    */
/**
     * Gets zipcode.
     *
     * @return the zipcode
     *//*

    public int getZipcode() {
        return zipcode;
    }


    */
/**
     * Sets zipcode.
     *
     * @param zipcode the zipcode
     *//*

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    */
/**
     * Gets email.
     *
     * @return the email
     *//*

    public String getEmail() {
        return email;
    }

    */
/**
     * Sets email.
     *
     * @param email the email
     *//*

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    */
/**
     * Gets preferences.
     *
     * @return the preferences
     *//*

    public Set<Preference> getPreferences() {
        return preferences;
    }

    */
/**
     * Sets preferences.
     *
     * @param preferences the preferences
     *//*

    public void setPreferences(Set<Preference> preferences) {
        this.preferences = preferences;
    }

*/

    /**
     * Add preference.
     *
     * @param preference the preference
     */
    public void addPreference(Preference preference) {
        preferences.add(preference);
        preference.setUser(this);
    }

    /**
     * Remove preference.
     *
     * @param preference the preference
     */
    public void removePreference(Preference preference) {
        preferences.remove(preference);
        preference.setUser(null);
    }

    /**
     * Add role.
     *

     */

    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);

    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                zipcode == user.zipcode &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, id, zipcode, password, email);
    }
}


