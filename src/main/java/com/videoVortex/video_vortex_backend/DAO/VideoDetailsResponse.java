package com.videoVortex.video_vortex_backend.DAO;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;



class Localized{
    public String title;
    public String description;
}


public class VideoDetailsResponse{
    public String kind;
    public String etag;
    public ArrayList<VideoDetailsItem> items;
}

class VideoDetailsItem {
    public String kind;
    public String etag;
    public String id;
    public VideoDetailsSnippet snippet;
    public Statistics statistics;
}

class VideoDetailsSnippet{
    public Date publishedAt;
    public String channelId;
    public String title;
    public String description;
    public VideoThumbnails thumbnails;
    public String channelTitle;
    public ArrayList<String> tags;
    public String categoryId;
    public String liveBroadcastContent;
    public String defaultLanguage;
    public Localized localized;
}


class VideoThumbnails{
    @JsonProperty("default")
    public Default mydefault;
    public Medium medium;
    public High high;
    public Standard standard;
    public Maxres maxres;
}

