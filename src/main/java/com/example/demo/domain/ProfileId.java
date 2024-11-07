package com.example.demo.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfileId implements Serializable {

    private String id;
    private String accountId;

    // Constructors
    public ProfileId() {}

    public ProfileId(String id, String accountId) {
        this.id = id;
        this.accountId = accountId;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    // Override equals() and hashCode() to ensure correct comparison of composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileId profileId = (ProfileId) o;
        return Objects.equals(id, profileId.id) && Objects.equals(accountId, profileId.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId);
    }
}