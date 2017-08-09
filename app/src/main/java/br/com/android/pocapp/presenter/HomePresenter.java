package br.com.android.pocapp.presenter;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.FilmsAdapter;
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

    private RecyclerView.Adapter mAdapter;

    private RecyclerView mRecyclerView;

    private FilmsModel mFilmsModel;

    private ArrayList<Films> mListFilms;

    private RecyclerView.LayoutManager mLayoutManager;

    public HomePresenter(HomeActivity mHomeActivity) {
        this.mHomeActivity = mHomeActivity;
        this.mFilmsModel = new FilmsModel(this);
        mRecyclerView = (RecyclerView) mHomeActivity.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mHomeActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mListFilms = new ArrayList<Films>();
    }

    public void list() {
        try {
            mFilmsModel.list();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void receiveList(JSONObject response) {
        ArrayList<Films> films = new ArrayList<Films>();
        try {
            JSONArray array = response.getJSONArray("results");
            for (int i=0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Films film = new Films();
                film.setmTitle(obj.getString("title"));
                film.setmDirector(obj.getString("director"));
                film.setmReleaseDate(new Date());
                films.add(film);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mAdapter = new FilmsAdapter(films);
        Log.i("Teste", ""+films.size());
        mRecyclerView.setAdapter(mAdapter);

    }
}
