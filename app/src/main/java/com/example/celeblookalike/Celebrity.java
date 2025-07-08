package com.example.celeblookalike;

public class Celebrity {
    private String name;
    private int imageResId;  // dùng resource nội bộ

    public Celebrity(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
