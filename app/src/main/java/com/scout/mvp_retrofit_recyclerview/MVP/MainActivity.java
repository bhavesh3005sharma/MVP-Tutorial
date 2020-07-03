package com.scout.mvp_retrofit_recyclerview.MVP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.scout.mvp_retrofit_recyclerview.Adapters.Adapter;
import com.scout.mvp_retrofit_recyclerview.Model.ModelUsers;
import com.scout.mvp_retrofit_recyclerview.R;
import com.scout.mvp_retrofit_recyclerview.Utils.HelperClass;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    MainActivityPresenter presenter;
    Adapter adapter;
    ArrayList<ModelUsers> list = new ArrayList<>();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        presenter = new MainActivityPresenter(MainActivity.this);
        presenter.start();
        presenter.loadUsersData();
    }

    @Override
    public void initUi() {
        HelperClass.showProgressbar(progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.hasFixedSize();
        adapter = new Adapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setErrorUi(String error) {
        HelperClass.hideProgressbar(progressBar);
        HelperClass.toast(this,error);
    }

    @Override
    public void updateUi(ArrayList<ModelUsers> data) {
        HelperClass.hideProgressbar(progressBar);
        list.clear();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
