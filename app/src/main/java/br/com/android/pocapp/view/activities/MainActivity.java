package br.com.android.pocapp.view.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import br.com.android.pocapp.R;
import br.com.android.pocapp.presenter.MainPresenter;

public class MainActivity extends Activity{

    /**
     * Instance of presenter login
     */
    private MainPresenter mMainPresenter;

    /*
     * Edit text user email
     */
    private EditText mUserEmail;

    /*
     * Edit text user password
     */
    private EditText mUserPassword;

    /**
     * Button login
     */
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an new instance of presenter
        if(mMainPresenter == null){
            mMainPresenter = new MainPresenter(this);
        }

        // Get elements in view
        findViews();
    }

    /**
     * Start new intent
     * @param view in context
     */
    public void RegisterNewUser(View view) {
        Intent intent = new Intent(this, UserInfoActivity.class);
        startActivity(intent);
    }

    /**
     * Listener to login button.
     */
    public Button.OnClickListener RegisterLoginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            doLogin(getUserData());
        }
    };

    /**
     * Call login method in presenter
     */
    public void doLogin(ArrayList<String> credentials) {
        boolean isLogged;
        isLogged = mMainPresenter.doLogin(credentials.get(0), credentials.get(1));
        checkStatusLogin(isLogged);
    }

    /**
     * Check status of login
     * @param isLogged
     */
    private void checkStatusLogin(boolean isLogged) {
        mMainPresenter.checkStatusLogin(isLogged);
     }

    /**
     * @return Array of credentials for validate login
     */
    public ArrayList<String> getUserData(){
        ArrayList<String> credentials;
        credentials = new ArrayList<String>();
        credentials.add(mUserEmail.getText().toString());
        credentials.add(mUserPassword.getText().toString());
        return credentials;
    }

    /**
     * Get elements in UI to validate login
     */
    private void findViews() {
        mUserEmail = (EditText) findViewById(R.id.editText);
        mUserPassword = (EditText) findViewById(R.id.editText2);
        mButtonLogin = (Button) findViewById(R.id.button);
        mButtonLogin.setOnClickListener(RegisterLoginClickListener);
    }

    public Context getActivityContext() {
        return this;
    }
}
