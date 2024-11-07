package com.example.demo.dto;

import java.util.Date;
import java.util.Optional;

public class NoticeDto {
    public String title;
    public String text;
    public Optional<Date> date;

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

    public Optional<Date> getDate() {
        return date;
    }

    public void setDate(Optional<Date> date) {
        this.date = date;
    }

    public NoticeDto() {}

    public NoticeDto(String title, String text, Optional<Date> date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }
}
