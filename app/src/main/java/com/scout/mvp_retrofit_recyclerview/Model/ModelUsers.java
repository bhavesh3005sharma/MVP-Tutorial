package com.scout.mvp_retrofit_recyclerview.Model;

import com.google.gson.annotations.SerializedName;

public class ModelUsers {
    @SerializedName("id")
    String userId;
    @SerializedName("name")
    String Name;
    @SerializedName("username")
    String userName;
    @SerializedName("email")
    String userEmail;
    @SerializedName("website")
    String website;

    public ModelUsers(String userId, String name, String userName, String userEmail, String website) {
        this.userId = userId;
        this.Name = name;
        this.userName = userName;
        this.userEmail = userEmail;
        this.website = website;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return Name;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getWebsite() {
        return website;
    }
}
