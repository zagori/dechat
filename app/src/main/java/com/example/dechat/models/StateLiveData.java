package com.example.dechat.models;

import androidx.lifecycle.MutableLiveData;

public class StateLiveData<T> extends MutableLiveData<Response> {
    /**
     * Use this to put the Data on a LOADING Status
     */
    public void postLoading() {
        postValue(new Response().loading());
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
     * @param data the load returned upon successful call
     */
    @SuppressWarnings("unchecked")
    public void postSuccess(T data) {
        postValue(new Response().success(data));
    }
}
