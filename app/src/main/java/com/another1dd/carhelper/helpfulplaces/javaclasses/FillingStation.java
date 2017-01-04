package com.another1dd.carhelper.helpfulplaces.javaclasses;

public class FillingStation {
    public String name;
    public String text;
    public Long id;


    public FillingStation(){}

    public FillingStation(String name, String text, Long id)
    {
        this.name = name;
        this.text = text;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }
}
