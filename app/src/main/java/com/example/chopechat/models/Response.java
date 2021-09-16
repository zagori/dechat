package com.example.chopechat.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Response<T> {
    @NonNull
    private Status status;

    @Nullable
    private List<T> data;

    @Nullable
    private Throwable error;

    public Response() {
        status = Status.LOADING;
    }

    public Response loading() {
        this.status = Status.LOADING;
        return this;
    }

    public Response success(@NonNull List<T> data) {
        this.status = Status.SUCCESS;
        this.data = data;
        return this;
    }

    public Response error(@NonNull Throwable error) {
        this.status = Status.ERROR;
        this.data = null;
        this.error = error;
        return this;
    }

    @NonNull
    public Status getStatus() {
        return status;
    }

    @Nullable
    public List<T> getData() {
        return data;
    }

    @Nullable
    public Throwable getError() {
        return error;
    }
}
