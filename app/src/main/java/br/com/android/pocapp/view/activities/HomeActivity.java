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

public class HomeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Films films = new Films();
        films.setmTitle("Teste");
        films.setmDirector("Teste Diretor");
        films.setmReleaseDate(new Date());

        ArrayList<Films> list = new ArrayList<Films>();
        list.add(films);
        mAdapter = new FilmsAdapter(list);
        mRecyclerView.setAdapter(mAdapter);

    }
}
