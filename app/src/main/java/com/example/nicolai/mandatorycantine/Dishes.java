package com.example.nicolai.mandatorycantine;

import java.io.Serializable;

/**
 * Created by Nicolai on 07-04-2017.
 */

public class Dishes implements Serializable {
/**
 * {"Alcohol":0,"Carbohydrates":582,"Description":"oatmeal porridge","Energy":2008,"Fat":17.9,"Id":1,"PictureUrl":"http:\/\/www.dk-kogebogen.dk\/billeder-opskrifter\/billeder\/4668\/4_300.jpg","Price":15,"Protein":16.5,"Title":"Oatmeal","Weight":323}
 */
    private double alcohol;
    private double carbohydrates;
    private String description;
    private int energy;
    private int fat;
    private int id;
    private String pictureUrl;
    private double price;
    private double protein;
    private String title;
    private double weight;

    public Dishes(double alcohol, double carbohydrates, String description, int energy, int fat, int id, String pictureUrl, double price, double protein, String title, double weight) {
        this.alcohol = alcohol;
        this.carbohydrates = carbohydrates;
        this.description = description;
        this.energy = energy;
        this.fat = fat;
        this.id = id;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.protein = protein;
        this.title = title;
        this.weight = weight;
    }

    public double getAlchohol() {
        return alcohol;
    }

    public void setAlchohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
