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


    /*
     * Constructor of class Presenter
     */
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

    /**
     * Method to check if user was created with sucess
     * @param results toast showing message of sucess or not
     */
    public void checkUserRegistration(boolean results) {
        if(results){
            Toast.makeText(mUserInfoActivity, "Usuário salvo com sucesso.", Toast.LENGTH_LONG).show();
            mUserInfoActivity.backView();
        }else{
            Toast.makeText(mUserInfoActivity, "Erro ao salvar usuário.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Method to validate empty fields in view
     * @return boolean false if match empty string in any field
     */
    public boolean checkFieldsEmpty() {
        if ((mUserInfoActivity.getmUserEmail().getText().toString().trim().matches("")) ||
                (mUserInfoActivity.getmUserCpf().getText().toString().trim().matches("")) ||
                (mUserInfoActivity.getmUserName().getText().toString().trim().matches("")) ||
                (mUserInfoActivity.getmUserPhone().getText().toString().trim().matches("")) ||
                (mUserInfoActivity.getmUserPassword().getText().toString().trim().matches(""))){
            return false;
        }
        return true;
    }

    /**
     * Toast to show empty fields
     */
    public void showToastEmptyFields() {
        Toast.makeText(mUserInfoActivity, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
    }
}
