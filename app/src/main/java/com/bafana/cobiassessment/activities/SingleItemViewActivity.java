package com.bafana.cobiassessment.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bafana.cobiassessment.http.ImageLoader;
import com.bafana.cobiassessment.R;
import com.bafana.cobiassessment.http.Version;

/**
 * Created by bafanamankahla on 2016/12/05.
 */

public class SingleItemViewActivity extends Activity {

    private String name;
    private String version;
    private String released;
    private String api;
    private String image;
    private ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        version = i.getStringExtra("version");
        released = i.getStringExtra("released");
        api = i.getStringExtra("api");
        image = i.getStringExtra("image");

        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvVersion = (TextView) findViewById(R.id.tv_version);
        TextView tvRelease = (TextView) findViewById(R.id.tv_release);
        TextView tvApi = (TextView) findViewById(R.id.tv_api);
        Version version = new Version();

        ImageView imgIcon = (ImageView) findViewById(R.id.iv_android_icon);

        tvName.setText(version.getName());
        tvVersion.setText(version.getVersion());
        tvRelease.setText(released);
        tvApi.setText(version.getApi());

        imageLoader.DisplayImage(image, imgIcon);
    }
}
