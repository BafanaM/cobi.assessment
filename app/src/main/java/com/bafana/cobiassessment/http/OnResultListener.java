package com.bafana.cobiassessment.http;

public interface OnResultListener<T> {
    void onSuccess(T data);
    void onFailure(String message);
}
