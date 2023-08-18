package com.pankaj.contesttime;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    @SerializedName("start_time")
    private String startTime;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("duration")
    private String duration;

    @SerializedName("site")
    private String site;

    @SerializedName("in_24_hours")
    private String in24Hours;

    @SerializedName("status")
    private String status;

    // Add constructors, getters, and setters here

    // Example constructor
    public Post(String name, String url, String startTime, String endTime, String duration, String site,
                String in24Hours, String status) {
        this.name = name;
        this.url = url;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.site = site;
        this.in24Hours = in24Hours;
        this.status = status;
    }

    // Example getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Repeat the above pattern for other properties
}
