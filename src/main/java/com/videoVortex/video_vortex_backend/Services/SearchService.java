package com.videoVortex.video_vortex_backend.Services;

import com.videoVortex.video_vortex_backend.DAO.HomePageRecommendationsResponse;
import com.videoVortex.video_vortex_backend.DAO.SearchResultsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SearchService {

    Logger logger = LoggerFactory.getLogger(VideoRecommendationsHomeService.class);

    @Autowired
    RestTemplate restTemplate;

    public SearchResultsResponse getSearchResults(String searchItem){
        try{
            String baseUrl = "https://youtube.googleapis.com/youtube/v3/search";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("part", "snippet")
                    .queryParam("q", searchItem)
                    .queryParam("maxResults", 25)
                    .queryParam("key", System.getenv("Youtube_API_Key"));
            String url = builder.toUriString();
            SearchResultsResponse response = restTemplate.getForObject(url, SearchResultsResponse.class);
            logger.info("API Response for search Results : "+response.kind);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("Error: " + e.getStatusCode());
            logger.info("Response Body: " + e.getResponseBodyAsString());
            // Additional handling based on the status code
            return null;
        }
    }
}
