package com.example.localfeeds.models;


import java.util.Date;

public class Announcement {

    private String id;
    private String idProductor;
    private String description;
    private Date date;

    public Announcement(String id, String idProductor, String description) {
        this.id = id;
        this.idProductor = idProductor;
        this.description = description;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
