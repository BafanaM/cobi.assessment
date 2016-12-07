package com.bafana.cobiassessment.http;

import java.io.Serializable;

public class Version implements Serializable {
    private String name;
    private String version;
    private String released;
    private String api;
    private String image;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getReleased() {
        return released;
    }

    public String getApi() {
        return api;
    }

    public String getImage() {
        return image;
    }
}