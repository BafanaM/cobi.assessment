package com.bafana.cobiassessment.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bafana.cobiassessment.R;
import com.bafana.cobiassessment.activities.MainActivity;
import com.bafana.cobiassessment.activities.SingleItemViewActivity;
import com.bafana.cobiassessment.http.ImageLoader;
import com.bafana.cobiassessment.http.Version;

import java.util.HashMap;
import java.util.List;

import static android.R.attr.data;
import static android.R.attr.version;

public class VersionsAdapter extends RecyclerView.Adapter<VersionsAdapter.VersionsHolder> {

    private final LayoutInflater inflater;
    private List<Version> versions;
    Context context;
    Version version;

    public VersionsAdapter(Context context, List<Version> versions, Version version){
        inflater =  LayoutInflater.from(context);
        this.versions = versions;
        this.context = context;
        this.version = version;
    }



    @Override
    public VersionsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, null, false);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SingleItemViewActivity.class);
                intent.putExtra("name", version.getName());
                intent.putExtra("version", version.getVersion());
                intent.putExtra("released",version.getReleased());
                intent.putExtra("api", version.getApi());
                context.startActivity(intent);
            }
        });
        return new VersionsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VersionsHolder holder, int position) {
        if(versions != null && !versions.isEmpty()) {
            Version version = versions.get(position);
            holder.tvName.setText(version.getName());
            holder.tvVersion.setText(version.getVersion());
            holder.tvRelease.setText(version.getReleased());
            holder.tvApi.setText(version.getApi());
            //holder.ivAndroidIcon.getDrawable();

            //imageLoader.DisplayImage(version.getImage(), holder.ivAndroidIcon);

        }
    }

    @Override
    public int getItemCount() {
        return versions.size();
    }

    public static class VersionsHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvVersion;
        TextView tvRelease;
        TextView tvApi;
        ImageView ivAndroidIcon;

        public VersionsHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvVersion = (TextView) itemView.findViewById(R.id.tv_version);
            tvRelease = (TextView) itemView.findViewById(R.id.tv_release);
            tvApi = (TextView) itemView.findViewById(R.id.tv_api);
            ivAndroidIcon = (ImageView) itemView.findViewById(R.id.iv_android_icon);
        }
    }
}
