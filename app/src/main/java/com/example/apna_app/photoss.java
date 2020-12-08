package com.example.apna_app;

public class photoss {

    private String Name;
    private int photo;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public photoss(String name, int photo) {
        Name = name;
        this.photo = photo;
    }
}
