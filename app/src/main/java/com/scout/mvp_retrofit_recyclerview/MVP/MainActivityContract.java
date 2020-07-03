package com.scout.mvp_retrofit_recyclerview.MVP;

import com.scout.mvp_retrofit_recyclerview.Model.ModelUsers;

import java.util.ArrayList;

public interface MainActivityContract {
    interface View{

        void setErrorUi(String error);

        void updateUi(ArrayList<ModelUsers> data);

        void initUi();
    }

    interface Presenter{

        void loadUsersData();
        
        void OnSuccess(ArrayList<ModelUsers> body);

        void onError(String error);

        void start();
    }
    
    interface Model{

        void getUsersList();
    }
}
