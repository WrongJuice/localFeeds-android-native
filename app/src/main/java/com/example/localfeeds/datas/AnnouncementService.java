package com.example.localfeeds.datas;

import com.example.localfeeds.models.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementService {

    public List<Announcement> getAnnouncements() {
        Announcement announcement1 = new Announcement("id1", "Arrivage de carotte !");
        Announcement announcement2 = new Announcement("id2", "Arrivage de tomate !");
        Announcement announcement3 = new Announcement("id3", "Arrivage de pomme !");
        Announcement announcement4 = new Announcement("id4", "Arrivage de pomme de terre !");
        Announcement announcement5 = new Announcement("id5", "Arrivage de raisin !");

        List<Announcement> announcements = new ArrayList<>();
        announcements.add(announcement1);
        announcements.add(announcement2);
        announcements.add(announcement3);
        announcements.add(announcement4);
        announcements.add(announcement5);
        return announcements;
    }

}
