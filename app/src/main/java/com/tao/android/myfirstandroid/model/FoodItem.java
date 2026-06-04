package com.tao.android.myfirstandroid.model;

import java.util.Objects;

/**
 * ClassName: FoodItem
 * Package: com.tao.android.myfristandroid.model
 * Description:
 *
 * @Author ct
 * @Create 2026/6/3 21:23
 * @Version 1.0
 */
public class FoodItem {
    String name;
    int imageResId;
    String description;

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        FoodItem foodItem = (FoodItem) object;
        return imageResId == foodItem.imageResId && Objects.equals(name, foodItem.name) && Objects.equals(description, foodItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageResId, description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodItem(String name, int imageResId, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
    }
}
