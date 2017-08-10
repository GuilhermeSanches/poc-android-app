package br.com.android.pocapp.model;

import android.database.Cursor;

import java.util.ArrayList;

import br.com.android.pocapp.dao.BootDao;
import br.com.android.pocapp.presenter.BootPresenter;


/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootInfoModel {
    private BootPresenter mPresenterBoot;

    private BootDao mBootDao;

    public BootInfoModel(BootPresenter mPresenterBoot) {
        this.mPresenterBoot = mPresenterBoot;
        this.mBootDao = new BootDao(mPresenterBoot.getActivityContext());
    }

    public Cursor list() {
        return mBootDao.list();
    }

    public void save(Integer type) {
        mBootDao.save(type);
    }

    public Cursor getByType(String type) {
        return mBootDao.getByType(type);
    }
}
