package com.nguyenoanh.layout;

public class Product {
    String title, topic,date, contentNew, comment, like;
    int image;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product() {
    }

    public Product(String title, String topic,String date, String contentNew, String comment, String like, int image) {
        this.title = title;
        this.topic = topic;
        this.date = date;
        this.contentNew = contentNew;
        this.comment = comment;
        this.like = like;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContentNew() {
        return contentNew;
    }

    public void setContentNew(String contentNew) {
        this.contentNew = contentNew;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
