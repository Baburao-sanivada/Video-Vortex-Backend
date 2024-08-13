package com.videoVortex.video_vortex_backend.DAO;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

class DefaultType{
    public String url;
    public int width;
    public int height;
}

class HighType{
    public String url;
    public int width;
    public int height;
}

class Id{
    public String kind;
    public String videoId;
}

class SearchResponseItem{
    public String kind;
    public String etag;
    public Id id;
    public SearchResponseItemSnippet snippet;
}

class MediumType{
    public String url;
    public int width;
    public int height;
}

class PageInfo{
    public int totalResults;
    public int resultsPerPage;
}

public class SearchResultsResponse{
    public String kind;
    public String etag;
    public String nextPageToken;
    public String regionCode;
    public PageInfo pageInfo;
    public ArrayList<SearchResponseItem> items;
}

class SearchResponseItemSnippet{
    public Date publishedAt;
    public String channelId;
    public String title;
    public String description;
    public ItemThumbnails thumbnails;
    public String channelTitle;
    public String liveBroadcastContent;
    public Date publishTime;
}

class ItemThumbnails{
    @JsonProperty("default")
    public DefaultType mydefault;
    public MediumType medium;
    public HighType high;
}

