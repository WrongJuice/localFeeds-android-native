package com.example.localfeeds.datas;

import com.example.localfeeds.models.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementService {
    Announcement announcement1;
    Announcement announcement2;
    Announcement announcement3;
    Announcement announcement4;
    Announcement announcement5;

    List<Announcement> announcements = new ArrayList<>();


    public AnnouncementService() {
        announcement1 = new Announcement("id1", "id1", "Arrivage de boeuf !");
        announcement2 = new Announcement("id2","id2", "Arrivage de tomate !");
        announcement3 = new Announcement("id3","id1", "Arrivage de thon !");
        announcement4 = new Announcement("id4","id2", "Arrivage de pomme de terre !");
        announcement5 = new Announcement("id5","id3", "Arrivage de bleu !");

        announcements.add(announcement1);
        announcements.add(announcement2);
        announcements.add(announcement3);
        announcements.add(announcement4);
        announcements.add(announcement5);
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public List<Announcement> getAnnouncementsById(String id){

        List<Announcement> productorAnnoucement = new ArrayList<>();

        for (Announcement announcement : announcements) {
            if (announcement.getId() == id){
                productorAnnoucement.add(announcement);
            }
        }

        return productorAnnoucement;
    }

}
