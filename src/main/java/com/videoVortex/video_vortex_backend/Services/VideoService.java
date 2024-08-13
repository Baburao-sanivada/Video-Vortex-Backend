package com.videoVortex.video_vortex_backend.Services;

import com.videoVortex.video_vortex_backend.DAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class VideoService {
    Logger logger = LoggerFactory.getLogger(VideoRecommendationsHomeService.class);

    @Autowired
    RestTemplate restTemplate;

    public VideoDetailsResponse getVideoDetails(String videoId){
        try{
            String baseUrl = "https://youtube.googleapis.com/youtube/v3/videos";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("part", "snippet,contentDetails,statistics")
                    .queryParam("id", videoId)
                    .queryParam("key", "AIzaSyC9hgB4pfQxk9V2cZmvq2si_LTXpsIvu2Q");
            String url = builder.toUriString();
            VideoDetailsResponse response = restTemplate.getForObject(url, VideoDetailsResponse.class);
            logger.info("API Response for search Results : "+response.kind);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("Error: " + e.getStatusCode());
            logger.info("Response Body: " + e.getResponseBodyAsString());
            // Additional handling based on the status code
            return null;
        }
    }

    public ChannelImageResponse getChannelImage(String channelId){
        try{
            String baseUrl = "https://youtube.googleapis.com/youtube/v3/channels";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("part", "snippet,contentDetails,statistics")
                    .queryParam("id", channelId)
                    .queryParam("key", "AIzaSyC9hgB4pfQxk9V2cZmvq2si_LTXpsIvu2Q");
            String url = builder.toUriString();
            ChannelImageResponse response = restTemplate.getForObject(url, ChannelImageResponse.class);
            logger.info("API Response for Channel Image : "+response.kind);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("Error: " + e.getStatusCode());
            logger.info("Response Body: " + e.getResponseBodyAsString());
            // Additional handling based on the status code
            return null;
        }
    }

    public VideoRecommendationsResponse getRecommendations(String channelId){
        try{
            String baseUrl = "https://www.googleapis.com/youtube/v3/activities";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("part", "snippet,contentDetails")
                    .queryParam("channelId", channelId)
                    .queryParam("maxResults", 50)
                    .queryParam("regionCode", "IN")
                    .queryParam("key", "AIzaSyC9hgB4pfQxk9V2cZmvq2si_LTXpsIvu2Q");
            String url = builder.toUriString();
            VideoRecommendationsResponse response = restTemplate.getForObject(url, VideoRecommendationsResponse.class);
            logger.info("API Response for Channel Image : "+response.kind);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("Error: " + e.getStatusCode());
            logger.info("Response Body: " + e.getResponseBodyAsString());
            // Additional handling based on the status code
            return null;
        }
    }


    public VideoCommentsResponse getComments(String videoId){
        try{
            String baseUrl = "https://www.googleapis.com/youtube/v3/commentThreads";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("part", "snippet")
                    .queryParam("textFormat", "plainText")
                    .queryParam("videoId", videoId)
                    .queryParam("maxResults", 100)
                    .queryParam("order", "relevance")
                    .queryParam("key", "AIzaSyC9hgB4pfQxk9V2cZmvq2si_LTXpsIvu2Q");
            String url = builder.toUriString();
            VideoCommentsResponse response = restTemplate.getForObject(url, VideoCommentsResponse.class);
            logger.info("API Response for Channel Image : "+response.kind);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("Error: " + e.getStatusCode());
            logger.info("Response Body: " + e.getResponseBodyAsString());
            // Additional handling based on the status code
            return null;
        }
    }

}
