package br.com.android.pocapp.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.FilmsAdapter;
import br.com.android.pocapp.domain.Films;
import br.com.android.pocapp.presenter.HomePresenter;

public class HomeActivity extends AppCompatActivity {

    private HomePresenter mPresenterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPresenterHome = new HomePresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenterHome.list();
    }

}
