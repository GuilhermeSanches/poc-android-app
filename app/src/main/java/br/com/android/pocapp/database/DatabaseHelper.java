package br.com.android.pocapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.android.pocapp.constants.ConstantsGlobalDatabase;
import br.com.android.pocapp.constants.ConstantsUserInfoTable;

/**
 * Created by guilherme.sanches on 07/08/2017.
 */
/**
 * Class to create POC database.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * Instance of class.
     */
    private static DatabaseHelper getDBHelper;

    /**
     * Database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Database name.
     */
    private static final String DATABASE_NAME = "poc.db";

    /**
     * Create table user info.
     */
    private static final String CREATE_TABLE_USER_INFO =
            "CREATE TABLE "
                    + ConstantsUserInfoTable.TABLE_USER_INFO
                    + "("
                    + ConstantsUserInfoTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + ConstantsUserInfoTable.COLUMN_USERNAME + " TEXT,"
                    + ConstantsUserInfoTable.COLUMN_PASSWORD + " TEXT,"
                    + ConstantsUserInfoTable.COLUMN_EMAIL + " TEXT,"
                    + ConstantsUserInfoTable.COLUMN_PHONE + " TEXT,"
                    + ConstantsUserInfoTable.COLUMN_CPF + " TEXT,"
                    + ConstantsGlobalDatabase.COLUMN_DATE_CREATE + "default CURRENT_TIMESTAMP"
                    + ")";

    /**
     * Constructor of class
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        /**
         * Creating database
         */
        if (sqLiteDatabase != null) {
            sqLiteDatabase.execSQL(CREATE_TABLE_USER_INFO);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,  int i1) {

        /**
         * Updatating database
         */
        if (sqLiteDatabase != null) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + ConstantsUserInfoTable.TABLE_USER_INFO);
        }
        onCreate(sqLiteDatabase);

    }

    /**
     * Get instance of DatabaseHelper.
     *
     * @param context context app.
     * @return An instance of DatabaseHelper.
     */
    public static synchronized DatabaseHelper getDBHelper(Context context) {
        if (getDBHelper == null) {
            getDBHelper = new DatabaseHelper(context);
        }
        return getDBHelper;
    }
}
