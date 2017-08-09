package br.com.android.pocapp.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.FilmsAdapter;
import br.com.android.pocapp.domain.Films;
import br.com.android.pocapp.presenter.HomePresenter;

public class HomeActivity extends AppCompatActivity {

    /**
     * Variable of presenter view
     */
    private HomePresenter mPresenterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Start presenter view
        mPresenterHome = new HomePresenter(this);
    }


    /**
     * Inflater menu itens
     * @param menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     *  Logic of event click in menu items.
      * @param item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                finish();
            case R.id.action_boot_info:
                Intent intent = new Intent(this, BootInfoActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Get list films StarWarS
        mPresenterHome.list();
    }

}
