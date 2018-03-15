package com.example.tangming.new2018;

import com.appbaselib.network.AbstractRetrofitHelper;

import java.util.List;

import okhttp3.Interceptor;

/**
 * Created by tangming on 2018/3/15.
 */

public class Http extends AbstractRetrofitHelper<API> {
    @Override
    protected String getHost() {
        return "http://192.168.0.211/";
    }

    @Override
    protected Class getAPI() {
        return API.class;

    }

    public static Http getInstance() {
        if (mInstance == null) {
            mInstance = new Http();
        }
        return (Http) mInstance;
    }

    public static API getDefault() {
        return getInstance().getApi();
    }

    @Override
    protected List<Interceptor> getCustomNetworkInterceptors() {
        return null;
    }

    @Override
    protected List<Interceptor> getCustomInterceptors() {
        return null;
    }
}
