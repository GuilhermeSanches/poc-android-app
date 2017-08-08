package br.com.android.pocapp.domain;

import java.util.Date;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class Films {
    private String mTitle;
    private String mDirector;
    private Date mReleaseDate;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDirector() {
        return mDirector;
    }

    public void setmDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    public Date getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(Date mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }
}
