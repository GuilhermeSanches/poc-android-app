package br.com.android.pocapp.model;

import android.database.Cursor;

import java.util.ArrayList;

import br.com.android.pocapp.dao.BootDao;
import br.com.android.pocapp.presenter.BootPresenter;


/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootInfoModel {

    /**
     * Instance of {@link BootPresenter}
     */
    private BootPresenter mPresenterBoot;

    /**
     * Instamce of {@link BootDao}
     */
    private BootDao mBootDao;

    /**
     * Constructor of class
     * @param mPresenterBoot is presenter of the view
     */
    public BootInfoModel(BootPresenter mPresenterBoot) {
        this.mPresenterBoot = mPresenterBoot;
        this.mBootDao = new BootDao(mPresenterBoot.getActivityContext());
    }

    /**
     * Call method list all in Dao
     */
    public Cursor list() {
        return mBootDao.list();
    }

    /*
     * Call method list with filter by type
     */
    public Cursor getByType(String type) {
        return mBootDao.getByType(type);
    }

    /*
     * Call method list with filter by date
     */
    public Cursor getByDate(int year, int month, int day) {
        return mBootDao.getByDate(year, month, day);
    }
}
