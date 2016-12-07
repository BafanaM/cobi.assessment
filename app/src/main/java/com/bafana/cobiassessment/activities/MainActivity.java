package com.bafana.cobiassessment.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bafana.cobiassessment.R;
import com.bafana.cobiassessment.adapters.VersionsAdapter;
import com.bafana.cobiassessment.http.NetworkService;
import com.bafana.cobiassessment.http.OnResultListener;
import com.bafana.cobiassessment.http.Version;
import com.bafana.cobiassessment.http.Versions;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        final RecyclerView rcVersions =  (RecyclerView) findViewById(R.id.rc_versions);
        rcVersions.setHasFixedSize(true);
        rcVersions.setLayoutManager(new LinearLayoutManager(this));

        String url  =  "http://codetest.cobi.co.za/androids.json";

         new NetworkService<Versions>(this, Versions.class,  new OnResultListener<Versions>() {
             @Override
             public void onSuccess(Versions data) {
                 VersionsAdapter adapter = new VersionsAdapter(MainActivity.this, Version.class);
                 rcVersions.setAdapter(adapter);
             }

             @Override
             public void onFailure(String message) {

             }
         }).execute(url);
    }
}
