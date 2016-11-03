package com.ironyard.ping.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jasonskipper on 10/24/16.
 */
@Entity
public class Player {
    private String firstName;
    private String lastName;
    private String alias;
    private int age;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Match> matches;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
