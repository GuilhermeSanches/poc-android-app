package br.com.android.pocapp.presenter;

import android.content.Context;
import android.widget.Toast;

import br.com.android.pocapp.domain.UserEntity;
import br.com.android.pocapp.model.UserModel;
import br.com.android.pocapp.view.activities.UserInfoActivity;

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
    public boolean insertNewUser(UserEntity user){
        return mModelUser.insertNewUser(user);
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

    public void checkUserRegistration(boolean results) {
        if(results){
            Toast.makeText(mUserInfoActivity, "Usuário salvo com sucesso.", Toast.LENGTH_LONG).show();
            mUserInfoActivity.backView();
        }else{
            Toast.makeText(mUserInfoActivity, "Erro ao salvar usuário.", Toast.LENGTH_LONG).show();
        }
    }
}
