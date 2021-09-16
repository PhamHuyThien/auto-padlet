package com.thiendz.tool.autopadlet.model;

public class Post {
    private long id;
    private String title;
    private String author;
    private String link;
    private String desc;
    private String img;
    private String date;
    private String guid;

    public Post() {
    }

    public Post(long id) {
        this.id = id;
    }

    public Post(long id, String title, String author, String link, String desc, String img, String date, String guid) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.link = link;
        this.desc = desc;
        this.img = img;
        this.date = date;
        this.guid = guid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", title=" + title + ", author=" + author + ", link=" + link + ", desc=" + desc + ", img=" + img + ", date=" + date + ", guid=" + guid + '}';
    }



}
