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
    private int duration;

    @SerializedName("site")
    private String site;

    @SerializedName("in_24_hours")
    private String in24Hours;

    @SerializedName("status")
    private String status;


    public Post(String name, String url, String startTime, String endTime, int duration, String site,
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIn24Hours() {
        return in24Hours;
    }

    public void setIn24Hours(String in24Hours) {
        this.in24Hours = in24Hours;
    }
}
