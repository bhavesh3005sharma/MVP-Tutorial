package com.scout.mvp_retrofit_recyclerview.Model;

import android.util.Log;

import com.scout.mvp_retrofit_recyclerview.MVP.MainActivityContract;
import com.scout.mvp_retrofit_recyclerview.Retrofit.ApiService;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMainActivity implements MainActivityContract.Model{
    MainActivityContract.Presenter presenter;

    public ModelMainActivity(MainActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void getUsersList() {
        ApiService.getAPIService().getUsersList()
        .enqueue(new Callback<ArrayList<ModelUsers>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelUsers>> call, Response<ArrayList<ModelUsers>> response) {
                if (response.isSuccessful())
                    presenter.OnSuccess(response.body());
                else {
                    assert response.errorBody() != null;
                    presenter.onError(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ModelUsers>> call, Throwable t) {
                presenter.onError(t.getMessage());
            }
        });
    }
}
