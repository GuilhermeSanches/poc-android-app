package br.com.android.pocapp.view.activities;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.SystemClock;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.BootAdapter;
import br.com.android.pocapp.presenter.BootPresenter;

public class BootInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private BootPresenter mBootPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_info);

        mBootPresenter = new BootPresenter(this);

        mBootPresenter.list();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_spinner, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.setMinimumWidth(100);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, R.layout.spinner_item_custom);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    public Context getActivityContext() {
        return this;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0){
            mBootPresenter.list();
        }else{
            mBootPresenter.getByType(adapterView.getAdapter().getItem(i).toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        return;
    }
}
