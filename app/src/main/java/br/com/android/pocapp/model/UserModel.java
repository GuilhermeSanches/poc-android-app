package br.com.android.pocapp.model;

import android.util.Log;

import br.com.android.pocapp.dao.UserInfoDao;
import br.com.android.pocapp.entity.UserEntity;
import br.com.android.pocapp.presenter.UserInfoPresenter;

/**
 * Created by guilherme.sanches on 07/08/2017.
 * Model for a user
 */

public class UserModel {

    private static final String TAG = "UserModel";
    private UserInfoPresenter mPresenterUser;
    private UserInfoDao mUserInfoDao;

    public UserModel(UserInfoPresenter presenterUser) {
        this.mPresenterUser = presenterUser;
        mUserInfoDao = new UserInfoDao(presenterUser.getActivityContext());
    }

    public void insertNewUser(UserEntity user) {
        Log.i(TAG, "Results sql insert user: "+mUserInfoDao.insertUserInfo(user));
    }

}
