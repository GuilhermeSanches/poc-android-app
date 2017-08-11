package br.com.android.pocapp.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import br.com.android.pocapp.R;
import br.com.android.pocapp.presenter.HomePresenter;
import br.com.android.pocapp.view.activities.MainActivity;

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
        if(mPresenterHome == null){
            mPresenterHome = new HomePresenter(this);
        }

        mPresenterHome.list();
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
        Intent intent;
        switch (item.getItemId()){
            case R.id.logout:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.action_boot_info:
                intent = new Intent(this, BootInfoActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Get list films StarWarS
//        mPresenterHome.list();
    }

}
