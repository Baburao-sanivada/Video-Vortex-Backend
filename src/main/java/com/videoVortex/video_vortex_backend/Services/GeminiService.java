package com.videoVortex.video_vortex_backend.Services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeminiService {

    Logger logger = LoggerFactory.getLogger(GeminiService.class);

    @Autowired
    RestTemplate restTemplate;

    private final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" +System.getenv("Gemini_API_Key");

    public List<String> getSearchSuggestions(String query) {

        // Set the headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Create the JSON request body
        JsonObject textObject = new JsonObject();
        textObject.addProperty("text", "Generate YouTube search suggestions starting with the query: '" + query + "'. Example: If the query is 'leo so', potential suggestions could include 'leo songs, leo songs telugu, leo songs download, etc.'");

        JsonArray partsArray = new JsonArray();
        partsArray.add(textObject);

        JsonObject contentsObject = new JsonObject();
        contentsObject.add("parts", partsArray);

        JsonArray contentsArray = new JsonArray();
        contentsArray.add(contentsObject);

        JsonObject requestBody = new JsonObject();
        requestBody.add("contents", contentsArray);

        // Make the request
        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(GEMINI_API_URL, HttpMethod.POST, entity, String.class);

        logger.info("Response from Gemini : "+response);
        return parseResponse(response.getBody());
    }


    private String generatePrompt(String query) {
        return "Act like a youtube search suggestion System and suggest popular YouTube search terms name based on the query: " + query;
//        " . Give only 5 movies names ',' comma seperated as show in the example ahead . Example : MovieName1,MovieName2,MovieName3,MovieName4,MovieName5";
    }

    private List<String> parseResponse(String responseBody) {
        List<String> suggestions = new ArrayList<>();

        // Parse the JSON response
        JsonObject responseJson = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonArray candidatesArray = responseJson.getAsJsonArray("candidates");

        if (candidatesArray != null && candidatesArray.size() > 0) {
            JsonObject candidate = candidatesArray.get(0).getAsJsonObject();
            JsonObject content = candidate.getAsJsonObject("content");
            JsonArray partsArray = content.getAsJsonArray("parts");

            if (partsArray != null && partsArray.size() > 0) {
                JsonObject part = partsArray.get(0).getAsJsonObject();
                String text = part.get("text").getAsString().trim();

                // Split suggestions by newlines and add to the list
                String[] suggestionsArray = text.split("\\n");
                for (String suggestion : suggestionsArray) {
                    if (suggestions.size() < 10) {
                        // Clean up each suggestion by removing leading/trailing special characters
                        String cleanedSuggestion = suggestion.replaceAll("[^a-zA-Z0-9\\s]", "").trim();
                        suggestions.add(cleanedSuggestion);
                    } else {
                        break;
                    }
                }
            }
        }

        return suggestions;
    }

//    private List<String> parseResponse(String responseBody) {
//        List<String> suggestions = new ArrayList<>();
//
//        // Parse the JSON response
//        JsonObject responseJson = JsonParser.parseString(responseBody).getAsJsonObject();
//        JsonArray contentsArray = responseJson.getAsJsonArray("contents");
//
//        if (contentsArray != null && contentsArray.size() > 0) {
//            JsonObject contentObject = contentsArray.get(0).getAsJsonObject();
//            JsonArray partsArray = contentObject.getAsJsonArray("parts");
//
//            for (JsonElement partElement : partsArray) {
//                JsonObject part = partElement.getAsJsonObject();
//                String text = part.get("text").getAsString().trim();
//
//                // Split suggestions and add to the list
//                String[] suggestionsArray = text.split(",\\s*");
//                for (String suggestion : suggestionsArray) {
//                    if (suggestions.size() < 10) {
//                        suggestions.add(suggestion);
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        logger.info("List of Suggestions: "+suggestions);
//        return suggestions;
//    }


}

