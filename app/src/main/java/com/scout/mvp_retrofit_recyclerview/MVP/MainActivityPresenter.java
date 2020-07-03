package com.scout.mvp_retrofit_recyclerview.MVP;

import com.scout.mvp_retrofit_recyclerview.Model.ModelMainActivity;
import com.scout.mvp_retrofit_recyclerview.Model.ModelUsers;
import java.util.ArrayList;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    MainActivityContract.View view;
    MainActivityContract.Model model;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        this.model = new ModelMainActivity(MainActivityPresenter.this);
    }

    @Override
    public void loadUsersData() {
        model.getUsersList();
    }

    @Override
    public void OnSuccess(ArrayList<ModelUsers> data) {
        if (view!=null) {
            view.updateUi(data);
        }
    }

    @Override
    public void onError(String error) {
        if (view!=null)
            view.setErrorUi(error);
    }

    @Override
    public void start() {
        view.initUi();
    }
}
