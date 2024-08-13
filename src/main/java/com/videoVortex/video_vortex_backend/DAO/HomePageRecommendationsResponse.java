package com.videoVortex.video_vortex_backend.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;



class Default{
    public String url;
    public int width;
    public int height;
}

class High{
    public String url;
    public int width;
    public int height;
}

class Item{
    public String kind;
    public String etag;
    public String id;
    public Snippet snippet;
    public Statistics statistics;
}

class Maxres{
    public String url;
    public int width;
    public int height;
}

class Medium{
    public String url;
    public int width;
    public int height;
}

public class HomePageRecommendationsResponse{
    public String kind;
    public String etag;
    public ArrayList<VideoDetailsItem> items;
}

class Snippet{
    public Date publishedAt;
    public String channelId;
    public String title;
    public String description;
    public Thumbnails thumbnails;
    public String channelTitle;
    public String categoryId;
}

class Standard{
    public String url;
    public int width;
    public int height;
}

class Statistics{
    public String viewCount;
    public String likeCount;
    public String favoriteCount;
    public String commentCount;
}

class Thumbnails{
    @JsonProperty("default")
    public Default mydefault;
    public Medium medium;
    public High high;
    public Standard standard;
    public Maxres maxres;
}