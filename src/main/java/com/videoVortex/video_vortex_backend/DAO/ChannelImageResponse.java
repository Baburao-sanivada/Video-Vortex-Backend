package com.videoVortex.video_vortex_backend.DAO;

import java.util.ArrayList;
import java.util.Date;

class ChannelImageItem{
    public String kind;
    public String etag;
    public String id;
    public ChannelImageSnippet snippet;
}

public class ChannelImageResponse{
    public String kind;
    public String etag;
    public ArrayList<ChannelImageItem> items;
}

class ChannelImageSnippet{
    public String title;
    public String description;
    public String customUrl;
    public Date publishedAt;
    public ChannelImageThumbnails thumbnails;
}

class ChannelImageThumbnails{
    public High high;
}
