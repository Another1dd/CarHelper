package com.another1dd.carhelper.helpfulplaces;



public class ServiceStation {
    public String name;
    public String text;

    public ServiceStation(){}

    public ServiceStation(String name, String text)
    {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
