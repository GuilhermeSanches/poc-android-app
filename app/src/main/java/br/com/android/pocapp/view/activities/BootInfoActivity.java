package br.com.android.pocapp.view.activities;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.BootAdapter;
import br.com.android.pocapp.presenter.BootPresenter;

public class BootInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,  DatePickerDialog.OnDateSetListener {

    /**
     * Instance of presenter view
     */
    private BootPresenter mBootPresenter;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_info);
        datePickerDialog = new DatePickerDialog(
                this.getActivityContext(), this, 2017, 7, 10);

        mBootPresenter = new BootPresenter(this);

        mBootPresenter.list();
    }

    /**
     * Set params to spinner in actionBar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_spinner, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.setMinimumWidth(100);

        /**
         * Settings of adapter to spinner
         */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, R.layout.spinner_item_custom);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.calendar:
                datePickerDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
     * Return this context view
     */
    public Context getActivityContext() {
        return this;
    }

    /**
     * Method to listener click in option menu
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
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

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        mBootPresenter.getByDate(year, month, day);
    }
}
