package com.example.localfeeds.models;

import java.util.ArrayList;

public class Preferences {

    private static double distance;
    private static String[] productCategories;
    private static ArrayList<Productor> favoriteProductors;

    public static double getDistance() {
        return distance;
    }

    public static void setDistance(double distance) {
        Preferences.distance = distance;
    }

    public static String[] getProductCategories() {
        return productCategories;
    }

    public static void setProductCategories(String[] productCategories) {
        Preferences.productCategories = productCategories;
    }

    public static ArrayList<Productor> getFavoriteProductors() {
        return favoriteProductors;
    }

    public static void setFavoriteProductors(ArrayList<Productor> favoriteProductors) {
        Preferences.favoriteProductors = favoriteProductors;
    }
}
