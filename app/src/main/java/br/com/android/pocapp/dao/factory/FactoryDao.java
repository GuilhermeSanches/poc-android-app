package br.com.android.pocapp.dao.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.android.pocapp.database.DatabaseHelper;

/**
 * Created by guilherme.sanches on 07/08/2017.
 * Class to access database
 */

public class FactoryDao {

    /**
     * Instance of database
     */
    protected SQLiteDatabase database;

    /**
     * TAG for Logs
     */
    private static final String TAG = "DatabaseHelper";

    /**
     * Instance of database helper
     */
    public static DatabaseHelper databaseHelper;

    /**
     * Constructor of class
     * @param context of app
     */
    public FactoryDao(Context context) {
        databaseHelper = DatabaseHelper.getDBHelper(context);
        try {
            database = databaseHelper.getWritableDatabase();
        }catch (SQLiteException exception){
            Log.i(TAG, "Error in create database");
            exception.printStackTrace();
        }

    }
    public SQLiteDatabase getDatabase(){
        return this.database;
    }
}
