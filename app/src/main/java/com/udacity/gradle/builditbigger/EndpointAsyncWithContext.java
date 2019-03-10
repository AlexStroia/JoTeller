package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import co.alexdev.displayactivitylib.JokeActivity;

public class EndpointAsyncWithContext extends EndpointAsync {
    private static final String TAG = "EndpointAsyncWithContex";
    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    @SuppressLint("StaticFieldLeak")
    private ProgressBar mProgressBar;

    public EndpointAsyncWithContext(Context mContext, ProgressBar progressBar) {
        this.mContext = mContext;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String result) {
        mProgressBar.setVisibility(View.GONE);
        mContext.startActivity(new Intent(mContext, JokeActivity.class)
                .putExtra(mContext.getResources().getString(R.string.intent_extra_joke), result));
    }
}
