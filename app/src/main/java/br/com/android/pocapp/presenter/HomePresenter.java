package br.com.android.pocapp.presenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import br.com.android.pocapp.R;
import br.com.android.pocapp.view.adapter.FilmsAdapter;
import br.com.android.pocapp.domain.Films;
import br.com.android.pocapp.model.FilmsModel;
import br.com.android.pocapp.view.activities.HomeActivity;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class HomePresenter {
    /**
     * Instance MainActivity
     */
    private HomeActivity mHomeActivity;

    /**
     * Adapter to recycleView
     */
    private RecyclerView.Adapter mAdapter;

    /**
     * RecycleView in UI
     */
    private RecyclerView mRecyclerView;

    /**
     * Instance of model
     */
    private FilmsModel mFilmsModel;

    /**
     * Array of model to adapter
     */
    private ArrayList<Films> mListFilms;

    /**
     * LayoutManager to handle recycleView
     */
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * Instance of progress bar in list
     */
    private ProgressBar mProgress;

    /*
     * Show update date of call get api
     */
    private TextView mTextUpdate;

    /**
     * Constructor of class
     * @param mHomeActivity
     */
    public HomePresenter(HomeActivity mHomeActivity) {
        this.mHomeActivity = mHomeActivity;
        this.mFilmsModel = new FilmsModel(this);
        mRecyclerView = (RecyclerView) mHomeActivity.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(mHomeActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mListFilms = new ArrayList<Films>();
        mProgress = (ProgressBar) mHomeActivity.findViewById(R.id.progressBar2);
        mTextUpdate = (TextView) mHomeActivity.findViewById(R.id.textViewUpdate);
    }

    /**
     * Call method list in model
     */
    public void list() {
        try {
            // Set progress visible
            mProgress.setVisibility(View.VISIBLE);
            mFilmsModel.list();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Callback call after of asyncTask http finished
     * Parse {@link JSONObject} to {@link ArrayList}
     * and set adapter to {@link RecyclerView}
     * @param response of API
     */
    public void receiveList(JSONObject response) {
        ArrayList<Films> films = new ArrayList<Films>();
        try {
            // Check progress and set invisible if exists
            if(mProgress.getVisibility() == View.VISIBLE){
                mProgress.setVisibility(View.INVISIBLE);
            }
            mTextUpdate.setText("Atualizado em: "+parseDateToStr(new Date()));
            JSONArray array = response.getJSONArray("results");
            for (int i=0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Films film = new Films();
                film.setmTitle(obj.getString("title"));
                film.setmDirector(obj.getString("director"));
                film.setmReleaseDate(formatDate(obj.getString("release_date")));
                films.add(film);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mAdapter = new FilmsAdapter(films, mHomeActivity);
        mRecyclerView.setAdapter(mAdapter);

    }

    /*
     * Return the context application
     */
    public Activity getContext() {
        return mHomeActivity.getActivityContext();
    }

    /*
     *parse Date to String
     */
    private String parseDateToStr(Date date){
        String resultDate;
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        resultDate = dateFormat.format(date);
        return resultDate;
    }

    /*
     * Format date String to Date
     */
    private Date formatDate(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date =  format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
     * Call asyncTask to get list films
     */
    public void setTimeAsyncTask() {
        mFilmsModel.callApiScheduler();
    }
}
