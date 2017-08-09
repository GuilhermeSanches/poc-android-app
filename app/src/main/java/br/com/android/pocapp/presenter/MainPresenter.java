package br.com.android.pocapp.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import br.com.android.pocapp.model.LoginModel;
import br.com.android.pocapp.view.activities.HomeActivity;
import br.com.android.pocapp.view.activities.MainActivity;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class MainPresenter {
    /**
     * Instance MainActivity
     */
    private MainActivity mLoginActivity;

    /**
     * Instance of model
     */
    private LoginModel mLoginModel;

    /*
     * Constructor of class
     */
    public MainPresenter(MainActivity mLoginActivity) {
        this.mLoginActivity = mLoginActivity;
        this.mLoginModel = new LoginModel(this);
    }

    /**
     * @param email
     * @param password
     * @return boolean representing if user was logged or not.
     */
    public boolean doLogin(String email, String password){
        boolean isLogged = true;
        isLogged = mLoginModel.doLogin(email, password);
        return isLogged;
    }

    /**
     * @return Activity context
     */
    public Context getActivityContext() {
        try {
            return mLoginActivity.getActivityContext();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Check if login is sucess or not and show toast
     * @param isLogged
     */
    public void checkStatusLogin(boolean isLogged) {
        if (isLogged) {
            Toast.makeText(mLoginActivity, "Seja bem vindo!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(mLoginActivity, HomeActivity.class);
            mLoginActivity.startActivity(intent);
        } else {
            Toast.makeText(mLoginActivity, "Usuário e/ou senha inválido!", Toast.LENGTH_LONG).show();
        }
    }

}
