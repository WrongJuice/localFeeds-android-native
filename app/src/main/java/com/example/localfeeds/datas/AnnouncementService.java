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

    ArrayList<Announcement> announcements = new ArrayList<>();


    public AnnouncementService() {
        announcement1 = new Announcement("id1", "id1", "Arrivage de boeuf !", "Arrivage de boeuf en provenance d'Espagne, ça part très vite dépêchez vous !");
        announcement2 = new Announcement("id2","id2", "Arrivage de tomate !", "Tomate cultivées maison bien mûres");
        announcement3 = new Announcement("id3","id1", "Arrivage de thon !", "Thon en provenance de l'océan Pacifique, très frais venez vite");
        announcement4 = new Announcement("id4","id2", "Arrivage de pomme de terre !", "Pommes de terre cultivées sans aucun additif");
        announcement5 = new Announcement("id5","id3", "Arrivage de bleu !", "Les tarifs sont négociables pour les habitués seulement :)");
        announcement5 = new Announcement("id6","id1", "Promotion", "Promos sur les légumes vert ! À ces prix là c'est cadeau");

        announcements.add(announcement1);
        announcements.add(announcement2);
        announcements.add(announcement3);
        announcements.add(announcement4);
        announcements.add(announcement5);
    }

    public ArrayList<Announcement> getAnnouncements() {
        return announcements;
    }

    public List<Announcement> getAnnouncementsById(String id){

        List<Announcement> productorAnnoucement = new ArrayList<>();

        for (Announcement announcement : announcements) {
            if (announcement.getId().equals(id)){
                productorAnnoucement.add(announcement);
            }
        }

        return productorAnnoucement;
    }

}
