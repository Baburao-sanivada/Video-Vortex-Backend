package com.videoVortex.video_vortex_backend.Controllers;

import com.videoVortex.video_vortex_backend.DAO.HomePageRecommendationsResponse;
import com.videoVortex.video_vortex_backend.Services.VideoRecommendationsHomeService;
import com.videoVortex.video_vortex_backend.Utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class VideoRecommendationsHomeController {

    @Autowired
    VideoRecommendationsHomeService videoRecommendationsService;

    @GetMapping("/getRecommendations")
    public ResponseEntity<ApiResponse> getRecommendations(){
        HomePageRecommendationsResponse response = videoRecommendationsService.getRecommendations();
        return new ResponseEntity<>(new ApiResponse(response,""), HttpStatus.OK);
    }
}
