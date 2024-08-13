package com.videoVortex.video_vortex_backend.DAO;


import java.util.ArrayList;
import java.util.Date;

class ContentDetails{
    public Upload upload;
}

class VideoRecommendationsResponseItem{
    public String kind;
    public String etag;
    public String id;
    public VideoRecommendationsResponseSnippet snippet;
    public ContentDetails contentDetails;
}


public class VideoRecommendationsResponse{
    public String kind;
    public String etag;
    public ArrayList<VideoRecommendationsResponseItem> items;
}

class VideoRecommendationsResponseSnippet{
    public Date publishedAt;
    public String channelId;
    public String title;
    public String description;
    public Thumbnails thumbnails;
    public String channelTitle;
    public String type;
}



class Upload{
    public String videoId;
}

