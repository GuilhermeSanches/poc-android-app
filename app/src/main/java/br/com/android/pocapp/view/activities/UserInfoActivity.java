package br.com.android.pocapp.view.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.android.pocapp.R;
import br.com.android.pocapp.domain.UserEntity;
import br.com.android.pocapp.presenter.UserInfoPresenter;

public class UserInfoActivity extends AppCompatActivity {

    /*
     * Presenter User Info instance
     */
    private UserInfoPresenter mPresenterUser;

    /*
     * EditText of name element
     */
    private EditText mUserName;

    /*
     * EditText of email element
     */
    private EditText mUserEmail;

    /*
     * EditText of password element
     */
    private EditText mUserPassword;

    /*
     * EditText of phone element
     */
    private EditText mUserPhone;

    /*
     * EditText of cpf element
     */
    private EditText mUserCpf;

    /*
     * EditText of name element
     */
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        findViews();

        // Create new User Presenter
        if(mPresenterUser == null) {
            mPresenterUser = new UserInfoPresenter(this);
        }
    }

    /**
     * Listener to register button.
     */
    public Button.OnClickListener RegisterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            insertNewUser(getUserData());
        }
    };

    /**
     * Method to get User data
     * @return User object
     */
    public UserEntity getUserData(){
        UserEntity user = new UserEntity();
        user.setmUserName(mUserName.getText().toString());
        user.setmUserEmail( mUserEmail.getText().toString());
        user.setmUserPassword(mUserPassword.getText().toString());
        user.setmUserPhone(mUserPhone.getText().toString());
        user.setmUserCpf( mUserCpf.getText().toString());
        return user;
    }

    /**
     * Method to find elements in UI
     */
    public void findViews(){
        mUserName = (EditText) findViewById(R.id.editText3);
        mUserEmail = (EditText) findViewById(R.id.editText4);
        mUserPassword = (EditText) findViewById(R.id.editText5);
        mUserPhone = (EditText) findViewById(R.id.editText6);
        mUserCpf = (EditText) findViewById(R.id.editText7);
        mBtnRegister = (Button) findViewById(R.id.button3);
        mBtnRegister.setOnClickListener(RegisterClickListener);
    }

    /**
     * Method to insert new user
     * @param user
     */
    public void insertNewUser (UserEntity user){
        boolean results = this.mPresenterUser.insertNewUser(user);
        showToast(results);
    }

    private void showToast(boolean results) {
        mPresenterUser.checkUserRegistration(results);
    }

    public void backView() {
        finish();
    }

    /**
     * @return  Activity context
     */
    public Context getActivityContext() {
        return this;
    }

    /**
     * @return  App context
     */
    public Context getAppContext() {
        return getApplicationContext();
    }
}
