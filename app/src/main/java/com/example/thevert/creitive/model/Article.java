package com.example.thevert.creitive.model;

public class Article {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article(String content) {
        this.content = content;
    }

    public String string() {
        return  content;
    }
}
