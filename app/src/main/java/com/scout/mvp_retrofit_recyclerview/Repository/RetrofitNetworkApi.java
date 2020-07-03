package com.scout.mvp_retrofit_recyclerview.Repository;

import com.scout.mvp_retrofit_recyclerview.Model.ModelUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitNetworkApi {

    @GET("users/")
    Call<ArrayList<ModelUsers>> getUsersList();
}
