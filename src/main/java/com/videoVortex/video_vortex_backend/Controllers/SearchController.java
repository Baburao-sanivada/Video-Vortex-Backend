package com.videoVortex.video_vortex_backend.Controllers;

import com.videoVortex.video_vortex_backend.DAO.SearchResultsResponse;
import com.videoVortex.video_vortex_backend.Services.GeminiService;
import com.videoVortex.video_vortex_backend.Services.SearchService;
import com.videoVortex.video_vortex_backend.Utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @Autowired
    GeminiService geminiService;

    @GetMapping("/suggestions")
    public ResponseEntity<ApiResponse> getSearchSuggestions(@RequestParam String searchText){
        List<String> suggestions = geminiService.getSearchSuggestions(searchText);
        return new ResponseEntity<>(new ApiResponse(suggestions,""), HttpStatus.OK);
    }

    @GetMapping("/searchResults")
    public ResponseEntity<ApiResponse> getSearchResults(@RequestParam String searchItem){
        SearchResultsResponse response = searchService.getSearchResults(searchItem);
        return new ResponseEntity<>(new ApiResponse(response,""), HttpStatus.OK);
    }
}
