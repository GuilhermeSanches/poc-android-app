package br.com.android.pocapp.presenter;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    private ProgressBar mProgress;

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
    }

    /**
     * Call method list in model
     */
    public void list() {
        try {
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
            if(mProgress.getVisibility() == View.VISIBLE){
                mProgress.setVisibility(View.INVISIBLE);
            }
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
}
