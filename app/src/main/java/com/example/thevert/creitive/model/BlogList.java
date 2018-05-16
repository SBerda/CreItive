package com.example.thevert.creitive.model;

public class BlogList {
    private int id;
    private String title;
    private String image_url;
    private String description;

    public int getId() {
        return id;
    }

    public BlogList(int id, String title, String image_url, String description) {
        this.id = id;
        this.title = title;
        this.image_url = image_url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getImage_url() {
        return image_url;
    }

    @Override
    public String toString() {
        return "BlogList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
