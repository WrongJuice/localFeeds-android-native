package com.example.localfeeds.datas;

import com.example.localfeeds.models.Product;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;
import java.util.List;

public class ProductorService {

    Productor productor1;
    Productor productor2;
    Productor productor3;
    Productor productor4;
    ArrayList<Productor> productors = new ArrayList<>();

    public ProductorService() {
        ArrayList<Product> productViande = new ArrayList<>();
        ArrayList<Product> productOther = new ArrayList<>();
        ArrayList<Product> productMilk = new ArrayList<>();

        productViande.add(Product.Viande);
        productOther.add(Product.Autre);productOther.add(Product.Legume);productOther.add(Product.Fruit);
        productMilk.add(Product.Laitage);

        productor1 = new Productor(
                "id1",
                "Ferme du puit",
                "7 rue du marais 17560 SAINT MARTIN",
                "0378654534",
                "Vendredi 12h - 18h",
                "Petite ferme en bord de mer, viande et poisson",
                "ferme1",
                productViande
        );
        productor2 = new Productor(
                "id2",
                "Marché au légume",
                "8 rue du test 17520 SAINT LARS",
                "028987674",
                "Mercredi et Jeudi 12h - 14h",
                "Le paradis des fruits et légumes ! Venez décrouvrir notre production, et caresser nos magnifiques poules",
                "ferme2",
                productOther
        );
        productor3 = new Productor(
                "id3",
                "Le bon fromager",
                "34 route perdu",
                "0378654534",
                "Du Lundi au Vendredi, 16h-19h",
                "Le meilleur fromage à la coupe à proximité de chez vous",
                "ferme3",
                productMilk
        );
        productor4 = new Productor(
                "id4",
                "Le producteur du soleil",
                "3 rue de la faim",
                "0394959595",
                "Mardi, 14h-19h",
                "Un des tout meilleur de sa région",
                "ferme4",
                productOther
        );
        productors.add(productor1);
        productors.add(productor2);
        productors.add(productor3);
        productors.add(productor4);
    }

    public List<Productor> getProductors() {
        return productors;
    }

    public  Productor getProductorById(String id) {
        for (Productor productor : productors) {
            if (productor.getId().equals(id)){
                return productor;
            }
        }
        return null;
    }
}
