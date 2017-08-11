package br.com.android.pocapp.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;


import br.com.android.pocapp.presenter.HomePresenter;
import br.com.android.pocapp.view.activities.HomeActivity;

/**
 * Created by guilherme.sanches on 11/08/2017.
 */

public class FilmsAsyncTask extends AsyncTask<Object, Object, Void> {

    /*
     * Instance of Activity
     */
    private HomeActivity mActivity;

    /**
     * Instance of Presenter Home
     */
    private HomePresenter mContext;

    public FilmsAsyncTask(HomeActivity activity, HomePresenter context) {
        this.mActivity = activity;
        this.mContext = context;
    }

    @Override
    protected Void doInBackground(Object... voids) {
        mActivity.runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        mContext.list();
                    }
                }
        );
        return null;
    }
}
