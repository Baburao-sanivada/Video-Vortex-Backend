package com.videoVortex.video_vortex_backend.Controllers;

import com.videoVortex.video_vortex_backend.DAO.ChannelImageResponse;
import com.videoVortex.video_vortex_backend.DAO.VideoCommentsResponse;
import com.videoVortex.video_vortex_backend.DAO.VideoDetailsResponse;
import com.videoVortex.video_vortex_backend.DAO.VideoRecommendationsResponse;
import com.videoVortex.video_vortex_backend.Services.VideoService;
import com.videoVortex.video_vortex_backend.Utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/details")
    public ResponseEntity<ApiResponse> getVideoDetails(@RequestParam String videoId){
        VideoDetailsResponse response = videoService.getVideoDetails(videoId);
        return new ResponseEntity<>(new ApiResponse(response,""), HttpStatus.OK);
    }

    @GetMapping("/channelImage")
    public ResponseEntity<ApiResponse> getChannelImage(@RequestParam String channelId){
        ChannelImageResponse response = videoService.getChannelImage(channelId);
        return new ResponseEntity<>(new ApiResponse(response,""),HttpStatus.OK);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<ApiResponse> getVideoRecommendations(@RequestParam String channelId){
        VideoRecommendationsResponse response = videoService.getRecommendations(channelId);
        return new ResponseEntity<>(new ApiResponse(response,""),HttpStatus.OK);
    }

    @GetMapping("/comments")
    public ResponseEntity<ApiResponse> getVideoComments(@RequestParam String videoId){
        VideoCommentsResponse commentsResponse = videoService.getComments(videoId);
        return new ResponseEntity<>(new ApiResponse(commentsResponse,""),HttpStatus.OK);
    }

}
