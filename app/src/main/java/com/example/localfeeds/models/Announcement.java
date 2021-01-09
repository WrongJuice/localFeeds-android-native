package com.example.localfeeds.models;

import com.google.firebase.Timestamp;

import java.util.Date;

public class Announcement {

    private String idProductor;
    private String description;
    private Date date;

    public Announcement(String idProductor, String description) {
        this.idProductor = idProductor;
        this.description = description;
        this.date = new Date();
    }

    public String getIdProductor() {
        return idProductor;
    }

    public void setIdProductor(String idProductor) {
        this.idProductor = idProductor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
