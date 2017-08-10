package br.com.android.pocapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

import br.com.android.pocapp.constants.ConstantsBootInfoTable;

/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootDao extends PocDao{
    /**
     * Constructor of class
     *
     * @param context of app
     */
    public BootDao(Context context) {
        super(context);
    }

    /**
     * Method to return list of boot info
     * @return
     */
    public Cursor list() {

        // columns to be returned
        String[] columns = {
                "*"
        };

        // Query user in table
        Cursor cursor = database.query(
                //Table to query
                ConstantsBootInfoTable.TABLE_BOOT_INFO,
                //columns to be returned
                columns,
                null,
                null,
                null,
                null,
                null);

        return cursor;

    }

    /**
     * Method to create query post new boot info
     * @param type
     * @return
     */
    public boolean save(Integer type) {
        ContentValues values;

        values = new ContentValues();
        values.put(ConstantsBootInfoTable.COLUMN_TYPE, type);
        return true ? database.insert(ConstantsBootInfoTable.TABLE_BOOT_INFO, null, values)
                != -1 : false;
    }

    public Cursor getByType(String type) {
        // columns to be returned
        String[] columns = {
                "*"
        };

        String selection =
                ConstantsBootInfoTable.COLUMN_TYPE + " = ?";

        String[] selectionArgs;
        if(type.equals("On")) {
             selectionArgs = new String[]{
                     "1"
             };
        }else{
             selectionArgs = new String[]{
                     "0"
             };
        }

        // Query user in table
        Cursor cursor = database.query(
                //Table to query
                ConstantsBootInfoTable.TABLE_BOOT_INFO,
                //columns to be returned
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        return cursor;

    }

    public Cursor getByDate(int year, int month, int day) {
        String date = formatDateToQuery(year, month, day);

        // columns to be returned
        String[] columns = {
                "*"
        };

        String selection =
                "date("+ConstantsBootInfoTable.COLUMN_TIME + ") = ?";

        String[] selectionArgs = {
                date
        };


        // Query user in table
        Cursor cursor = database.query(
                //Table to query
                ConstantsBootInfoTable.TABLE_BOOT_INFO,
                //columns to be returned
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        return cursor;

    }

    private String formatDateToQuery(int year, int month, int day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return format.format(calendar.getTime());
    }
}
