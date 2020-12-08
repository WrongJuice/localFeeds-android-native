package com.example.localfeeds.models;

public class Preferences {

    private static double distance;
    private static String[] productCategories;

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
}
