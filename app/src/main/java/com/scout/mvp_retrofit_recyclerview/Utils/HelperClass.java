package com.scout.mvp_retrofit_recyclerview.Utils;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HelperClass {

    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static void toast(Context context , String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public static void showProgressbar(ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
    }

    public static void hideProgressbar(ProgressBar progressBar) {
        progressBar.setVisibility(View.GONE);
    }
}
