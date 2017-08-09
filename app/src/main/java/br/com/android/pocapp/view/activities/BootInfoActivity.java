package br.com.android.pocapp.view.activities;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;

import java.util.ArrayList;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.BootAdapter;
import br.com.android.pocapp.presenter.BootPresenter;

public class BootInfoActivity extends AppCompatActivity{

    private BootPresenter mBootPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_info);

        mBootPresenter = new BootPresenter(this);

        mBootPresenter.list();
    }

    public Context getActivityContext() {
        return this;
    }
}
