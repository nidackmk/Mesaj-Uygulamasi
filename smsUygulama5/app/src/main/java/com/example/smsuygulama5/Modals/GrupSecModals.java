package com.example.smsuygulama5.Modals;

public class GrupSecModals {
    String name;
    String description;
    String img;

    public GrupSecModals() {
    }

    public GrupSecModals(String name, String description, String img) {
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
