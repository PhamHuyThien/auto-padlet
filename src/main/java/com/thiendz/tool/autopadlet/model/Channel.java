
package com.thiendz.tool.autopadlet.model;

import java.util.List;


public class Channel {

    private String title;
    private String link;
    private String desc;
    private String language;
    private String date;
    private String master;
    private List<Post> items;

    public Channel() {
    }

    public Channel(String title, String link, String desc, String language, String date, String master, List<Post> items) {
        this.title = title;
        this.link = link;
        this.desc = desc;
        this.language = language;
        this.date = date;
        this.master = master;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public List<Post> getItems() {
        return items;
    }

    public void setItems(List<Post> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Channel{" + "title=" + title + ", link=" + link + ", desc=" + desc + ", language=" + language + ", date=" + date + ", master=" + master + ", items=" + items + '}';
    }
    
}
