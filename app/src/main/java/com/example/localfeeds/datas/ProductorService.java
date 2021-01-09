package com.example.localfeeds.datas;

import com.example.localfeeds.models.Productor;

import java.util.ArrayList;
import java.util.List;

public class ProductorService {

    public List<Productor> getProductors() {

        ArrayList<String> productViande = new ArrayList<>();
        ArrayList<String> productOther = new ArrayList<>();
        ArrayList<String> productMilk = new ArrayList<>();
        ArrayList<Productor> productors = new ArrayList<>();

        productViande.add("Poisson");productViande.add("Viande");
        productOther.add("Oeuf");productOther.add("Légumes");productOther.add("Fruit");
        productMilk.add("Laitage");

        Productor productor1 = new Productor("Ferme du puit",
                "7 rue du marais 17560 SAINT MARTIN",
                "0378654534",
                "Vendredi 12h - 18h",
                "Petite ferme en bord de mer, viande et poisson",
                    productViande
                );
        Productor productor2 = new Productor("Marché au légume",
                "8 rue du test 17520 SAINT LARS",
                "028987674",
                "mercredi et jeudi 12h - 14h",
                "Le paradis des fruits et légumes ! Venez décrouvrir notre production, et caresser nos magnifiques poules",
                productOther
        );
        Productor productor3 = new Productor("Le bon fromager",
                "34 route perdu",
                "0378654534",
                "Du lundi au vendredi, 16h-19h",
                "Le meilleur fromage à la coupe à proximité de chez vous",
                productMilk
        );

        productors.add(productor1);
        productors.add(productor2);
        productors.add(productor3);

        return productors;
    }


}
