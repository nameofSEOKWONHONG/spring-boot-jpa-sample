package com.example.demo.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="profile")
public class Profile implements Serializable {
    @EmbeddedId
    private ProfileId profileId;  // Composite primary key

    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;

    // Constructors
    public Profile() {}

    public Profile(ProfileId profileId, String name, int age) {
        this.profileId = profileId;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public ProfileId getProfileId() {
        return profileId;
    }

    public void setProfileId(ProfileId profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
