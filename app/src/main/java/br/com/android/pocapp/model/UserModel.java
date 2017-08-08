package br.com.android.pocapp.model;

import android.util.Log;

import br.com.android.pocapp.dao.UserInfoDao;
import br.com.android.pocapp.domain.UserEntity;
import br.com.android.pocapp.presenter.UserInfoPresenter;

/**
 * Created by guilherme.sanches on 07/08/2017.
 * Model for a user
 */

public class UserModel {

    /**
     * TAG for Logs
     */
    private static final String TAG = "UserModel";

    /**
     * Instance of presenter
     */
    private UserInfoPresenter mPresenterUser;

    /**
     * Instance of DAO
     */
    private UserInfoDao mUserInfoDao;

    /*
     * Constructor of class
     */
    public UserModel(UserInfoPresenter presenterUser) {
        this.mPresenterUser = presenterUser;
        mUserInfoDao = new UserInfoDao(presenterUser.getActivityContext());
    }

    /**
     * @param user to be inserted in database
     */
    public boolean insertNewUser(UserEntity user) {
        boolean results = mUserInfoDao.insertUserInfo(user);
        Log.i(TAG, "Sql inserted user: "+results);
        return results;
    }

}
