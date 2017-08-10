package br.com.android.pocapp.presenter;

import android.content.Context;
import android.database.Cursor;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.BootAdapter;
import br.com.android.pocapp.constants.ConstantsBootInfoTable;
import br.com.android.pocapp.constants.ConstantsUserInfoTable;
import br.com.android.pocapp.domain.BootInfo;
import br.com.android.pocapp.model.BootInfoModel;
import br.com.android.pocapp.view.activities.BootInfoActivity;

/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootPresenter {

    /**
     * Instance of the activity
     */
    private BootInfoActivity mBootActivity;

    /**
     * Instance of model
     */
    private BootInfoModel mBootModel;

    /**
     * {@link RecyclerView} in UI
     */
    private RecyclerView mRecView;

    /**
     * Manager linear layout
     */
    private LinearLayoutManager mLayoutManager;

    /**
     * Adapter to {@link RecyclerView}
     */
    private BootAdapter adapter;

    /**
     * Constructor of class
     * @param mBootActivity
     */
    public BootPresenter(BootInfoActivity mBootActivity) {
        this.mBootActivity = mBootActivity;
        this.mBootModel = new BootInfoModel(this);
        this.mRecView = (RecyclerView) mBootActivity.findViewById(R.id.boot_recycler_view);
        this.mLayoutManager = new LinearLayoutManager(this.mBootActivity);
        this.mRecView.setLayoutManager(this.mLayoutManager);
    }

    /**
     * Call list method in model
     */
    public void list() {
        Cursor cursor =  mBootModel.list();
        ArrayList<BootInfo> list =  formatData(cursor);
        setAdapterView(list);
    }

    /**
     * Method to call get with params type
     * @param type
     */
    public void getByType(String type) {
        Cursor cursor =  mBootModel.getByType(type);
        ArrayList<BootInfo> list =  formatData(cursor);
        setAdapterView(list);
    }

    /**
     * This method convert {@link Cursor} to {@link ArrayList}
     * @param cursor
     * @return
     */
    private ArrayList<BootInfo> formatData(Cursor cursor) {
        ArrayList<BootInfo> mArrayList = new ArrayList<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            BootInfo bootInfo = new BootInfo();
            bootInfo.setmType(cursor.getInt(cursor.getColumnIndex(ConstantsBootInfoTable.COLUMN_TYPE)));
            String strCursor = cursor.getString(cursor.getColumnIndex(
                            ConstantsBootInfoTable.COLUMN_TIME));
            bootInfo.setmTime(strCursor);
            mArrayList.add(bootInfo);
            cursor.moveToNext();
        }
        return mArrayList;
    }

    /**
     * Call method sabe in model
     * @param type
     */
    public void saveEvent(Integer type) {
        this.mBootModel.save(type);
    }

    /**
     * Constructor of class
     * @param list
     */
    private void setAdapterView(ArrayList<BootInfo> list) {
        adapter = new BootAdapter(list);
        mRecView.setAdapter(adapter);
    }

    /**
     * Method to format date in view
     * @param mili
     * @param format
     * @return
     */
    public String getDateString(long mili, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mili);
        return formatter.format(calendar.getTime());
    }

    /**
     * @return  Activity context
     */
    public Context getActivityContext() {
        try {
            return mBootActivity.getActivityContext();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
