package com.scout.mvp_retrofit_recyclerview.Retrofit;

import com.scout.mvp_retrofit_recyclerview.Repository.RetrofitNetworkApi;
import com.scout.mvp_retrofit_recyclerview.Utils.HelperClass;

public class ApiService {
    private ApiService() {}

    public static RetrofitNetworkApi getAPIService() {
        return RetrofitClient.getClient(HelperClass.BASE_URL).create(RetrofitNetworkApi.class);
    }
}
