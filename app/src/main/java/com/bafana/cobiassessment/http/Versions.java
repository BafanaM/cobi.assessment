package com.bafana.cobiassessment.http;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Versions implements Serializable {

    private List<Version> versions;

    public List<Version> getVersions() {
        return versions;
    }
}
