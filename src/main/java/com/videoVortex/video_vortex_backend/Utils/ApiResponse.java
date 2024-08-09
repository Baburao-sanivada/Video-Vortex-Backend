package com.videoVortex.video_vortex_backend.Utils;

public class ApiResponse {
    private Object response;
    private String error;

    public ApiResponse(Object response,String error) {
        this.error = error;
        this.response = response;
    }

    public ApiResponse() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
