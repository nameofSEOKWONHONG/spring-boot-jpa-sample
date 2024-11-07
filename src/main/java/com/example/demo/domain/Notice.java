package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private Date date;

    @Column(name="create_by")
    private String createBy;

    @Column(name="create_on")
    private Date createOn;

    @Column(name="modified_by")
    private String modifiedBy;

    @Column(name="modified_on")
    private Date modifiedOn;

    @Column(name="is_active")
    private Boolean isActive;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name="Language")
    private String language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Notice() {

    }

    public Notice(String title, String text, Date date, String createBy, Date createOn, boolean isActive) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.createBy = createBy;
        this.createOn = createOn;
        this.isActive = isActive;
    }
}
