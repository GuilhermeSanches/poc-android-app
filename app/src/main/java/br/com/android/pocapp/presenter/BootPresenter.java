package br.com.android.pocapp.presenter;

import android.content.Context;
import android.database.Cursor;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import br.com.android.pocapp.R;
import br.com.android.pocapp.view.adapter.BootAdapter;
import br.com.android.pocapp.constants.ConstantsBootInfoTable;
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
    private BootAdapter mAdapter;


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
     * @param type to filter
     */
    public void getByType(String type) {
        Cursor cursor =  mBootModel.getByType(type);
        ArrayList<BootInfo> list =  formatData(cursor);
        setAdapterView(list);
    }

    /**
     * This method convert {@link Cursor} to {@link ArrayList}
     * @param cursor of the query
     * @return aaray of boot info
     */
    private ArrayList<BootInfo> formatData(Cursor cursor) {
        ArrayList<BootInfo> mArrayList = new ArrayList<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            BootInfo bootInfo = new BootInfo();
            bootInfo.setmType(cursor.getInt(cursor.getColumnIndex(ConstantsBootInfoTable.COLUMN_TYPE)));
            String strCursor = cursor.getString(cursor.getColumnIndex(
                            ConstantsBootInfoTable.COLUMN_TIME));
            String  dateFormated = getDateString(strCursor);
            bootInfo.setmTime(dateFormated);
            mArrayList.add(bootInfo);
            cursor.moveToNext();
        }
        return mArrayList;
    }

    /**
     * Check if list is empty and set adapter to {@link RecyclerView}
     * @param list of bootInfo
     */
    private void setAdapterView(ArrayList<BootInfo> list) {
        mAdapter = new BootAdapter(list);
        if (list.size() == 0){
            mRecView.setVisibility(View.GONE);
            mBootActivity.findViewById(R.id.empty_list).setVisibility(View.VISIBLE);
        }else{
            mRecView.setVisibility(View.VISIBLE);
            mBootActivity.findViewById(R.id.empty_list).setVisibility(View.GONE);
            mRecView.setAdapter(mAdapter);
        }
    }

    /**
     * Method to format date in view
     * @param date string
     * @return Date in string formatted
     */
    private String getDateString(String date) {
        Date dateFormat;
        Calendar calendar = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        try {
            calendar = Calendar.getInstance();
            dateFormat = formatter.parse(date);
            calendar.setTime(dateFormat);
            calendar.add(Calendar.HOUR, -3);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatter2.format(calendar.getTime());
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

    /**
     * Call method list filtering by date
     * @param year of thedate
     * @param month of the date
     * @param day of the date
     */
    public void getByDate(int year, int month, int day) {
        Cursor cursor =  mBootModel.getByDate(year, month, day);
        ArrayList<BootInfo> list =  formatData(cursor);
        setAdapterView(list);
    }
}
