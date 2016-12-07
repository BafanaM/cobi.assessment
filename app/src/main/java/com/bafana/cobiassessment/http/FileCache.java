package com.bafana.cobiassessment.http;

import android.content.Context;

import java.io.File;

/**
 * Created by bafanamankahla on 2016/12/05.
 */

public class FileCache {

    private final File cacheDir;

    public FileCache(Context context) {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED))
            cacheDir = new File(
                    android.os.Environment.getExternalStorageDirectory(),
                    "JsonParseCobiCache");
        else
            cacheDir = context.getCacheDir();
        if (!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url) {
        String filename = String.valueOf(url.hashCode());
        File file = new File(cacheDir, filename);
        return file;

    }

}
