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

    private BootInfoActivity mBootActivity;

    private BootInfoModel mBootModel;

    private RecyclerView mRecView;

    private LinearLayoutManager mLayoutManager;

    private BootAdapter adapter;

    public BootPresenter(BootInfoActivity mBootActivity) {
        this.mBootActivity = mBootActivity;
        this.mBootModel = new BootInfoModel(this);
        this.mRecView = (RecyclerView) mBootActivity.findViewById(R.id.boot_recycler_view);
        this.mLayoutManager = new LinearLayoutManager(this.mBootActivity);
        this.mRecView.setLayoutManager(this.mLayoutManager);
    }

    public void list() {
        Cursor cursor =  mBootModel.list();
        ArrayList<BootInfo> list =  formatData(cursor);
        setAdapterView(list);
    }

    private ArrayList<BootInfo> formatData(Cursor cursor) {
        ArrayList<BootInfo> mArrayList = new ArrayList<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            BootInfo bootInfo = new BootInfo();
            bootInfo.setmType(cursor.getInt(cursor.getColumnIndex(ConstantsBootInfoTable.COLUMN_TYPE)));
            String strCursor = cursor.getString(cursor.getColumnIndex(
                            ConstantsBootInfoTable.COLUMN_TIME));
            Log.i("teste 2: ", strCursor);
//            Long dateMili = new Date(strCursor).getTime();
//            Log.i("teste 3: ", ""+dateMili);
//            String str = getDateString(dateMili, "dd/MM/yyyy hh:mm:ss");
            bootInfo.setmTime(strCursor);
            mArrayList.add(bootInfo); //add the item
            cursor.moveToNext();
        }
        return mArrayList;
    }

    public void saveEvent(Integer type) {
        this.mBootModel.save(type);
    }

    private void setAdapterView(ArrayList<BootInfo> list) {
        adapter = new BootAdapter(list);
        mRecView.setAdapter(adapter);
    }

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
