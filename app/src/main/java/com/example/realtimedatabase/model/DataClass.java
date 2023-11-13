package com.example.realtimedatabase.model;

public class DataClass {

    private String title;
    private String desc;

    private String key;

    public DataClass() {
    }

    public DataClass(String title, String desc, String key) {
        this.title = title;
        this.desc = desc;
        this.key = key;
    }

    public DataClass(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
