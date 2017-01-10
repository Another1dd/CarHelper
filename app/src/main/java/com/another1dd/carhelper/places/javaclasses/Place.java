package com.another1dd.carhelper.places.javaclasses;

public class Place {
    public String name;
    public String text;
    public String adress;
    public String image;
    public Long id;


    public Place(){}

    public Place(String name, String text, String image,String adress, Long id)
    {
        this.name = name;
        this.text = text;
        this.image = image;
        this.adress = adress;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getAdress() {
        return adress;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }
}
