package br.com.android.pocapp.model;

/**
 * Created by guilherme.sanches on 07/08/2017.
 * Model for a user
 */

public class User {

    /**
     * The id from the user.
     */
    private Long mUserId;

    /**
     * The name from the user.
     */
    private String mUserName;

    /**
     * The password from the user.
     */
    private String mUserPassword;

    /**
     * The email from the user.
     */
    private String mUserEmail;

    /**
     * The CPF from the user.
     */
    private String mUserCpf;

    /**
     * The telephone from the user.
     */
    private String mUserPhone;

    public Long getmUserId() {
        return mUserId;
    }

    public void setmUserId(Long mUserId) {
        this.mUserId = mUserId;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserPassword() {
        return mUserPassword;
    }

    public void setmUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword;
    }

    public String getmUserEmail() {
        return mUserEmail;
    }

    public void setmUserEmail(String mUserEmail) {
        this.mUserEmail = mUserEmail;
    }

    public String getmUserCpf() {
        return mUserCpf;
    }

    public void setmUserCpf(String mUserCpf) {
        this.mUserCpf = mUserCpf;
    }

    public String getmUserPhone() {
        return mUserPhone;
    }

    public void setmUserPhone(String mUserPhone) {
        this.mUserPhone = mUserPhone;
    }
}
