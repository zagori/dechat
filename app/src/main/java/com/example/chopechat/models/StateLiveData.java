package com.example.chopechat.models;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class StateLiveData<T> extends MutableLiveData<Response<T>> {
    /**
     * Use this to put the Data on a LOADING Status
     */
    public void postLoading() {
        postValue(new <T>Response<T>().loading());
    }

    /**
     * Use this to put the Data on a ERROR Status
     * @param throwable the error to be handled
     */
    public void postError(Throwable throwable) {
        postValue(new Response().error(throwable));
    }

    /**
     * Use this to put the Data on a SUCCESS Status
     * @param data the load returned upon successful network call
     */
    @SuppressWarnings("unchecked")
    public void postSuccess(List<T> data) {
        postValue(new Response().success(data));
    }
}
