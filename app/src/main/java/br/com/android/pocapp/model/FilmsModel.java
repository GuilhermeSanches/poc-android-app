package br.com.android.pocapp.model;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.android.pocapp.presenter.HomePresenter;
import br.com.android.pocapp.rest.tasks.HttpUtils;
import cz.msebera.android.httpclient.Header;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class FilmsModel{
    /**
     * TAG for Logs
     */
    private static final String TAG = "FilmsModel";

    /**
     * Instance of presenter
     */
    private HomePresenter mPresenterHome;

    /**
     * Constructor of model
     * @param mPresenterHome
     */
    public FilmsModel(HomePresenter mPresenterHome) {
        this.mPresenterHome = mPresenterHome;
    }

    /**
     * Method to list all films of StarWars API
     * @throws JSONException
     */
    public void list() throws JSONException {
        HttpUtils.get("films", null, responseList);
    }

    /**
     * Callback to method get list all
     */
    public JsonHttpResponseHandler responseList = new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            mPresenterHome.receiveList(response);
        }

        public void onFailure(int statusCode, Header[] headers, JSONObject response) {
            Log.i(TAG, response.toString());
        }
    };

}
