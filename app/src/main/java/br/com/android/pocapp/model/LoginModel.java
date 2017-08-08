package br.com.android.pocapp.model;

import android.util.Log;

import br.com.android.pocapp.dao.LoginDao;
import br.com.android.pocapp.presenter.MainPresenter;

/**
 * Class of  model of login
 * Created by guilherme.sanches on 08/08/2017.
 */

public class LoginModel {

    /**
     * TAG for Logs
     */
    private static final String TAG = "LoginModel";

    /**
     * Instance of presenter
     */
    private MainPresenter mMainPresenter;

    /**
     * Instance of DAO
     */
    private LoginDao mLoginDao;

    public LoginModel(MainPresenter presenter) {
        this.mMainPresenter = presenter;
        mLoginDao = new LoginDao(mMainPresenter.getActivityContext());
    }

    public boolean doLogin(String email, String password) {
        boolean results = mLoginDao.doLogin(email, password);
        Log.i(TAG, "Sql login user: "+results);
        return  results;
    }
}
