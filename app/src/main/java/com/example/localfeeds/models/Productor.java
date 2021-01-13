package com.example.localfeeds.models;

import java.util.ArrayList;

public class Productor {

    private String id;
    private String name;
    private String adresse;
    private String contact;
    private String schedule;
    private String desc;
    private String image;
    private ArrayList<Product> typeProduit;

    public Productor(String id, String name, String adresse, String contact, String schedule, String desc, String image, ArrayList<Product> typeProduit) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.contact = contact;
        this.schedule = schedule;
        this.desc = desc;
        this.image = image;
        this.typeProduit = typeProduit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Product> getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(ArrayList<Product> typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
