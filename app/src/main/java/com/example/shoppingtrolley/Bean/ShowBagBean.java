package com.example.shoppingtrolley.Bean;



public class ShowBagBean {


    private String path;
    private String title;
    private String num;

    public ShowBagBean(String path, String title, String num) {
        this.path = path;
        this.title = title;
        this.num = num;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}

