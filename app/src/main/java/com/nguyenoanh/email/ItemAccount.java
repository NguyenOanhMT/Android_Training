package com.nguyenoanh.email;

import android.graphics.drawable.Drawable;

public class ItemAccount {
    private int id;
    private String iconName;
    private String name;
    private String content;
    private String time;
    private int cardView;
    private boolean isChecked;

    public ItemAccount(int id, String name, String content, String time, int cardView) {
        this.id = id;
        this.iconName = name.substring (0,1).toUpperCase ();
        this.name = name;
        this.content = content;
        this.time = time;
        this.cardView = cardView;
        this.isChecked = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCardView() {
        return cardView;
    }

    public void setCardView(int cardView) {
        this.cardView = cardView;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
