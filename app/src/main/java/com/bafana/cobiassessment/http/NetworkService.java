package com.bafana.cobiassessment.http;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public final class NetworkService<T> extends AsyncTask<String, Void , T> {
    private final Gson gson;
    private OnResultListener<T>  callback;
    private ProgressDialog progressDialog;
    private Context context;
    private Class clazz;

    public NetworkService(Context context, Class<T> clazz,  OnResultListener<T> callback){
        this.context = context;
        this.callback  = callback;
        this.clazz = clazz;
        gson =  new Gson();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Android Cobi Assessment");
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }

    @Override
    protected T doInBackground(String... params) {
        String url =  params[0];
        String result = executeRequest(url);
        T data = (T) gson.fromJson(result, clazz);
        return data;
    }

    @Override
    protected void onPostExecute(T data) {
        progressDialog.dismiss();
        if(data == null){
            callback.onFailure("Service Error");
        }else{
            callback.onSuccess(data);
        }
    }

    public String executeRequest(String url)  {
        try {
            URL uri =  new URL(url);
            HttpURLConnection httpURLConnection =   (HttpURLConnection) uri.openConnection();
            InputStream is = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            StringBuilder buffer = new StringBuilder();
            String line;
            while ( (line = reader.readLine()) != null ) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (IOException e) {
            Log.e("log tag", "Error converting result " + e.toString());
            return "";
        }
    }
}
