package com.videoVortex.video_vortex_backend.DAO;

import java.util.ArrayList;

class AuthorChannelId{
    public String value;
}

class CommentItem{
    public String kind;
    public String etag;
    public String id;
    public CommentSnippet snippet;
}

class CommentSnippet{
    public String channelId;
    public String videoId;
    public TopLevelComment topLevelComment;
}

public class VideoCommentsResponse{
    public String kind;
    public String etag;
    public ArrayList<CommentItem> items;
}

class TopLevelCommentSnippet{
    public String channelId;
    public String videoId;
    public String textDisplay;
    public String textOriginal;
    public String authorDisplayName;
    public String authorProfileImageUrl;
    public String authorChannelUrl;
    public AuthorChannelId authorChannelId;
}

class TopLevelComment{
    public String kind;
    public String etag;
    public String id;
    public TopLevelCommentSnippet snippet;
}
