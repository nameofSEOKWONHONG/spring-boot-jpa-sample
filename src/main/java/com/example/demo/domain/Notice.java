package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Notice", schema = "customer")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Title")
    private String title;

    @Column(name="Text")
    private String text;

    @Column(name="Date")
    private Date date;

    @Column(name="CreateBy")
    private String createBy;

    @Column(name="CreateOn")
    private Date createOn;

    @Column(name="ModifiedBy")
    private String modifiedBy;

    @Column(name="ModifiedOn")
    private Date modifiedOn;

    @Column(name="IsActive")
    private Boolean isActive;

    @Column(name="FID")
    private String fId;

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

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }


    public Notice() {

    }

    public Notice(int id, String title, String text, Date date, String createBy, Date createOn) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.createBy = createBy;
        this.createOn = createOn;
    }
}
