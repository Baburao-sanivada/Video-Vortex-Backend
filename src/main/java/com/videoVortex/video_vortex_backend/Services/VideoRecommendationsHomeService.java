package com.videoVortex.video_vortex_backend.Services;

import com.videoVortex.video_vortex_backend.DAO.HomePageRecommendationsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class VideoRecommendationsHomeService {

    Logger logger = LoggerFactory.getLogger(VideoRecommendationsHomeService.class);

    @Autowired
    RestTemplate restTemplate;

    public HomePageRecommendationsResponse getRecommendations() {
        try{
            String baseUrl = "https://youtube.googleapis.com/youtube/v3/videos";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("part", "snippet,contentDetails,statistics")
                    .queryParam("chart", "mostPopular")
                    .queryParam("maxResults", 50)
                    .queryParam("regionCode", "IN")
                    .queryParam("key", System.getenv("Youtube_API_Key"));
            String url = builder.toUriString();
            HomePageRecommendationsResponse response = restTemplate.getForObject(url, HomePageRecommendationsResponse.class);
            logger.info("API Response : "+response.kind);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("Error: " + e.getStatusCode());
            logger.info("Response Body: " + e.getResponseBodyAsString());
            // Additional handling based on the status code
            return null;
        }
    }
}
