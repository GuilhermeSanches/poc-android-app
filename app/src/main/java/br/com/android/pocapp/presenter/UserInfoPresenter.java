package br.com.android.pocapp.presenter;

import android.content.Context;

import br.com.android.pocapp.dao.UserInfoDao;
import br.com.android.pocapp.entity.UserEntity;
import br.com.android.pocapp.model.UserModel;
import br.com.android.pocapp.model.UserModel;
import br.com.android.pocapp.view.UserInfoActivity;

/**
 * Created by guilherme.sanches on 07/08/2017.
 * Class to presenter data of user
 */

public class UserInfoPresenter {

    /**
     * Instance UserInfoActivity
     */
    private UserInfoActivity mUserInfoActivity;

    /*
     * Model User Info variable
     */
    private UserModel mModelUser;


    public UserInfoPresenter(UserInfoActivity userInfoActivity) {
        this.mUserInfoActivity = userInfoActivity;
        this.mModelUser = new UserModel(this);
    }

    /**
     * Method to persist user in database
     * @param user object
     */
    public void insertNewUser(UserEntity user){
        mModelUser.insertNewUser(user);
    }

    /**
     * @return  Activity context
     */
    public Context getActivityContext() {
        try {
            return mUserInfoActivity.getActivityContext();
        } catch (NullPointerException e) {
            return null;
        }
    }

}
